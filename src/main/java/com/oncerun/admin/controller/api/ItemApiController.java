package com.oncerun.admin.controller.api;

import com.oncerun.admin.controller.CrudController;
import com.oncerun.admin.domain.network.request.ItemApiRequest;
import com.oncerun.admin.domain.network.response.ItemApiResponse;
import com.oncerun.admin.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;


    @PostConstruct
    public void init(){
        this.baseService = itemApiLogicService;
    }
}
