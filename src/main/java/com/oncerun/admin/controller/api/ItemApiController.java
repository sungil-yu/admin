package com.oncerun.admin.controller.api;

import com.oncerun.admin.domain.network.Header;
import com.oncerun.admin.domain.network.request.ItemApiRequest;
import com.oncerun.admin.domain.network.response.ItemApiResponse;
import com.oncerun.admin.itf.CrudInterface;
import com.oncerun.admin.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;


    @Override
    @PostMapping
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {

        return itemApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<ItemApiResponse> read(@PathVariable Long id) {

        return itemApiLogicService.read(id);
    }

    @Override
    @PutMapping
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {

        return itemApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<ItemApiResponse> delete(@PathVariable Long id) {

        return null;
    }
}
