package com.oncerun.admin.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminUser {

    private Long id;

    private String account;

    private String password;

    private String status;

    private String role;

    private LocalDateTime lastLoginAt;

    private LocalDateTime passwordUpdatedAt;

    //default = 0
    private int loginFailCount;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;


}
