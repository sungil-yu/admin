package com.oncerun.admin.service;

import com.oncerun.admin.domain.entity.Partner;
import com.oncerun.admin.domain.network.Header;
import com.oncerun.admin.domain.network.request.PartnerApiRequest;
import com.oncerun.admin.domain.network.response.PartnerApiResponse;
import org.springframework.stereotype.Service;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest, PartnerApiResponse, Partner> {



    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
        return null;
    }

    @Override
    public Header<PartnerApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("No Data"));
    }

    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
        return null;
    }

    @Override
    public Header<PartnerApiResponse> delete(Long id) {
        return null;
    }

    private Header<PartnerApiResponse> response(Partner partner) {

        PartnerApiResponse body = PartnerApiResponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .address(partner.getAddress())
                .ceoName(partner.getCeoName())
                .callCenter(partner.getCallCenter())
                .partnerNumber(partner.getPartnerNumber())
                .businessNumber(partner.getBusinessNumber())
                .registeredAt(partner.getRegisteredAt())
                .unregisteredAt(partner.getUnregisteredAt())
                .categoryId(partner.getCategory().getId())
                .build();

        return Header.OK(body);
    }
}
