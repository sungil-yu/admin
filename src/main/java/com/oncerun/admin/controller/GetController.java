package com.oncerun.admin.controller;

import com.oncerun.admin.domain.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {


    @GetMapping("/header")
    public Header getHeader(){

        return Header.builder().resultCode("Ok").description("Ok").build();
    }
}
