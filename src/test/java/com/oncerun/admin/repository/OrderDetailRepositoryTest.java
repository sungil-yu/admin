package com.oncerun.admin.repository;

import com.oncerun.admin.domain.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    void create(){

        OrderDetail orderDetail = OrderDetail.builder()
                .status("WAITING")
                .arrivalDate(LocalDateTime.now().plusDays(2))
                .itemId(1L)
                .quantity(1)
                .totalPrice(BigDecimal.valueOf(900000))
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .build();

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        assertThat(newOrderDetail).isNotNull();




    }
}