package com.oncerun.admin.service;

import com.oncerun.admin.domain.entity.OrderGroup;
import com.oncerun.admin.domain.network.Header;
import com.oncerun.admin.domain.network.request.OrderGroupApiRequest;
import com.oncerun.admin.domain.network.response.OrderGroupApiResponse;
import com.oncerun.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {

        OrderGroupApiRequest body = request.getData();

        OrderGroup orderGroup = OrderGroup.builder()
                .status(body.getStatus())
                .orderType(body.getOrderType())
                .revAddress(body.getRevAddress())
                .revName(body.getRevName())
                .paymentType(body.getPaymentType())
                .totalPrice(body.getTotalPrice())
                .totalQuantity(body.getTotalQuantity())
                .orderAt(LocalDateTime.now())
                .arrivalDate(body.getArrivalDate())
                .user(userRepository.getOne(body.getUserId()))
                .build();

        OrderGroup newOrderGroup = baseRepository.save(orderGroup);



        return response(newOrderGroup);
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("NO DATA"));

    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {

        OrderGroupApiRequest body = request.getData();

     return   baseRepository.findById(body.getId())
                .map(orderGroup -> {
                    orderGroup
                            .setStatus(body.getStatus())
                            .setOrderType(body.getOrderType())
                            .setOrderAt(body.getOrderAt())
                            .setRevName(body.getRevName())
                            .setRevAddress(body.getRevAddress())
                            .setPaymentType(body.getPaymentType())
                            .setTotalPrice(body.getTotalPrice())
                            .setTotalQuantity(body.getTotalQuantity())
                            .setArrivalDate(body.getArrivalDate())
                            .setUser(userRepository.getOne(body.getUserId()));

                    return orderGroup;

                })
                .map(changeOrderGroup -> baseRepository.save(changeOrderGroup))
                .map(this::response)
                .orElseGet(() -> Header.ERROR("No Data"));


    }

    @Override
    public Header delete(Long id) {

        return baseRepository.findById(id)

                .map(orderGroup -> {
                    baseRepository.delete(orderGroup);
                    return Header.OK();

                })
                .orElseGet(() -> Header.ERROR("No Data"));



    }

    private Header<OrderGroupApiResponse> response(OrderGroup orderGroup){

        OrderGroupApiResponse body = OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .paymentType(orderGroup.getPaymentType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .userId(orderGroup.getUser().getId())
                .build();

        return Header.OK(body);
    }
}
