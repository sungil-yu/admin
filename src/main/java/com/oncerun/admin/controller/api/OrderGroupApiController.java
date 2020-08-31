package com.oncerun.admin.controller.api;

import com.oncerun.admin.domain.entity.OrderGroup;
import com.oncerun.admin.domain.network.Header;
import com.oncerun.admin.domain.network.request.OrderGroupApiRequest;
import com.oncerun.admin.domain.network.response.OrderGroupApiResponse;
import com.oncerun.admin.itf.CrudInterface;
import com.oncerun.admin.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Override
    @PostMapping
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {

        return orderGroupApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {


        return orderGroupApiLogicService.read(id);
    }

    @Override
    @PutMapping
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header<OrderGroupApiResponse> delete(@PathVariable Long id) {
        return null;
    }


}
