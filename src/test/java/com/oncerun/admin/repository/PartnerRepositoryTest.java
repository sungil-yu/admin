package com.oncerun.admin.repository;

import com.oncerun.admin.AdminApplicationTests;
import com.oncerun.admin.domain.entity.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class PartnerRepositoryTest extends AdminApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    void create(){

        Partner partner = Partner.builder()
                .name("Partner01")
                .status("REGISTERED")
                .address("서울시 강남구")
                .callCenter("070-1111-2222")
                .partnerNumber("010-1111-2222")
                .businessNumber("1234567890123")
                .ceoName("홍길동")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .categoryId(2L)
                .build();

        Partner newPartner = partnerRepository.save(partner);

        assertThat(newPartner).isNotNull();
    }
}