package com.oncerun.admin.repository;

import com.oncerun.admin.domain.entity.OrderGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderGroupRepositoryTest {

    @Autowired
    private OrderGroupRepository orderGroupRepository;


    @Test
    void create(){

        OrderGroup orderGroup = OrderGroup.builder()
                .status("COMPLETE")
                .orderType("ALL")
                .revAddress("서울시 강남구")
                .revName("홍길동")
                .orderAt(LocalDateTime.now().minusDays(2))
                .paymentType("CARD")
                .totalPrice(BigDecimal.valueOf(9000000))
                .totalQuantity(1)
                .arrivalDate(LocalDateTime.now())
                .userId(1L)
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .build();

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

        assertThat(newOrderGroup).isNotNull();
    }
}