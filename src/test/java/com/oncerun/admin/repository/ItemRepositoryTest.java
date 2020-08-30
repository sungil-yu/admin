package com.oncerun.admin.repository;

import com.oncerun.admin.AdminApplicationTests;
import com.oncerun.admin.domain.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest extends AdminApplicationTests {


    @Autowired
    private ItemRepository itemRepository;

    @Test
    void create(){

        Item item = Item.builder()
                .status("UNREGISTERED")
                .name("삼성노트북")
                .title("삼성 노트북 A100")
                .content("2020년형 노트북 입니다.")
                .price(900000)
                .brandName("삼성")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("Partner01")
                .partnerId(1L)
                .build();

        Item newItem = itemRepository.save(item);

        assertThat(newItem).isNotNull();
    }
}