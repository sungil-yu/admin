package com.oncerun.admin.repository;

import com.oncerun.admin.AdminApplicationTests;
import com.oncerun.admin.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    void read(){
        String phoneNumber = "010-1111-2222";

      User oldUser =  userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);

        assertThat(oldUser).isNotNull();
    }
}