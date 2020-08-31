package com.oncerun.admin.controller.api;

import com.oncerun.admin.controller.CrudController;
import com.oncerun.admin.domain.network.request.UserApiRequest;
import com.oncerun.admin.domain.network.response.UserApiResponse;
import com.oncerun.admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest,UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = userApiLogicService;
    }
}
