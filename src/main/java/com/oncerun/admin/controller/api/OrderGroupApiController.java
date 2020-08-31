package com.oncerun.admin.controller.api;

import com.oncerun.admin.controller.CrudController;
import com.oncerun.admin.domain.network.request.OrderGroupApiRequest;
import com.oncerun.admin.domain.network.response.OrderGroupApiResponse;
import com.oncerun.admin.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;


    @PostConstruct
    public void init(){
        this.baseService = orderGroupApiLogicService;
    }


}
