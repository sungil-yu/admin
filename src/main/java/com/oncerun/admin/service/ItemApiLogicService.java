package com.oncerun.admin.service;

import com.oncerun.admin.domain.entity.Item;
import com.oncerun.admin.domain.network.Header;
import com.oncerun.admin.domain.network.request.ItemApiRequest;
import com.oncerun.admin.domain.network.response.ItemApiResponse;
import com.oncerun.admin.itf.CrudInterface;
import com.oncerun.admin.repository.ItemRepository;
import com.oncerun.admin.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

        ItemApiRequest body = request.getData();

        Item item = Item.builder()
                .name(body.getName())
                .brandName(body.getBrandName())
                .content(body.getContent())
                .price(body.getPrice())
                .title(body.getTitle())
                .status(body.getStatus())
                .registeredAt(LocalDateTime.now())
                .partner(partnerRepository.getOne(body.getPartnerId()))
                .build();

        Item newItem = itemRepository.save(item);

        return response(newItem);
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {

        return itemRepository.findById(id)
                .map(item -> response(item))
                .orElseGet(() -> Header.ERROR("No Item"));

    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {

        ItemApiRequest body = request.getData();

        return itemRepository.findById(body.getId())
                .map(entityItem -> {
                    entityItem
                            .setStatus(body.getStatus())
                            .setName(body.getName())
                            .setTitle(body.getTitle())
                            .setContent(body.getContent())
                            .setPrice(body.getPrice())
                            .setBrandName(body.getBrandName())
                            .setRegisteredAt(body.getRegisteredAt())
                            .setUnregisteredAt(body.getUnregisteredAt());

                    return entityItem;
                })
                .map(newEntity -> itemRepository.save(newEntity))
                .map(item -> response(item))
                .orElseGet(() -> Header.ERROR("No Data"));

    }

    @Override
    public Header delete(Long id) {

        return itemRepository.findById(id)
                .map( item -> {
                    itemRepository.delete(item);

                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("NO ID"));

    }


    private Header<ItemApiResponse> response(Item item){

        ItemApiResponse body = ItemApiResponse
                .builder()
                .id(item.getId())
                .status(item.getStatus())
                .brandName(item.getBrandName())
                .name(item.getName())
                .title(item.getTitle())
                .price(item.getPrice())
                .content(item.getContent())
                .registeredAt(item.getRegisteredAt())
                .unregisteredAt(item.getUnregisteredAt())
                .partnerId(item.getPartner().getId())
                .build();

        return Header.OK(body);
    }

}
