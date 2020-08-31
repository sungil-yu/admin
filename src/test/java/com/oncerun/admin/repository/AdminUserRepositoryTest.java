package com.oncerun.admin.repository;

import com.oncerun.admin.domain.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdminUserRepositoryTest {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    void create() throws InterruptedException {
        AdminUser adminUser = AdminUser.builder()
                .account("AdminUser03")
                .password("AdminUser03")
                .role("PARTNER")
                .status("REGISTERED")
//                .createdAt(LocalDateTime.now())
//                .createdBy("AdminServer")
                .build();

        AdminUser newAdminUser = adminUserRepository.save(adminUser);

        assertThat(newAdminUser).isNotNull();

        newAdminUser.setAccount("updated");
        adminUserRepository.save(newAdminUser);
    }

}
