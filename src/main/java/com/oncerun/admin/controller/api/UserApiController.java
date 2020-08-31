package com.oncerun.admin.controller.api;

import com.oncerun.admin.domain.network.Header;
import com.oncerun.admin.domain.network.request.UserApiRequest;
import com.oncerun.admin.domain.network.response.UserApiResponse;
import com.oncerun.admin.itf.CrudInterface;
import com.oncerun.admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest,UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping()
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {

        log.info("{}",request);

        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable Long id) {

        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
        return userApiLogicService.update(userApiRequest);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return userApiLogicService.delete(id);
    }
}
