package com.oncerun.admin.repository;

import com.oncerun.admin.AdminApplicationTests;
import com.oncerun.admin.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void create(){
        User user = User.builder()
                .account("Test01")
                .password("Test01")
                .status("REGISTERED")
                .email("Test01@gmail.com")
                .phoneNumber("010-1111-2222")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .build();

        User newUser = userRepository.save(user);

        assertThat(newUser).isNotNull();

    }

    @Test
    @Transactional
    void read(){
        String phoneNumber = "010-1111-2222";

      User user =  userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("-------주문 묶음-------------");
            System.out.println(orderGroup);


            System.out.println("-------주문 상세-------------");
            orderGroup.getOrderDetailList().stream().forEach( orderDetail -> {
                System.out.println(orderDetail.getItem().getPartner().getCategory());
                System.out.println(orderDetail.getItem());
                System.out.println(orderDetail.getItem().getPartner());
                System.out.println(orderDetail);

            });


        });


        assertThat(user).isNotNull();
    }
}