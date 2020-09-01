package com.oncerun.admin.domain.network.response;

import com.oncerun.admin.domain.enumclass.PartnerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartnerApiResponse {

    private Long id;

    private String name;

    private PartnerStatus status;

    private String address;

    private String partnerNumber;

    private String businessNumber;

    private String callCenter;

    private String ceoName;

    private Long categoryId;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

}
