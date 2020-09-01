package com.oncerun.admin.service;

import com.oncerun.admin.domain.entity.User;
import com.oncerun.admin.domain.enumclass.UserStatus;
import com.oncerun.admin.domain.network.Header;
import com.oncerun.admin.domain.network.request.UserApiRequest;
import com.oncerun.admin.domain.network.response.UserApiResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService  extends BaseService<UserApiRequest, UserApiResponse,User> {


    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        UserApiRequest userApiRequest = request.getData();

        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = baseRepository.save(user);

        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("데이터 없음"));


    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        UserApiRequest userApiRequest = request.getData();

        Optional<User> optional = baseRepository.findById(userApiRequest.getId());

        return optional
                .map(user -> {

                    user
                            .setAccount(userApiRequest.getAccount())
                            .setPassword(userApiRequest.getPassword())
                            .setEmail(userApiRequest.getEmail())
                            .setStatus(UserStatus.REGISTERED)
                            .setUnregisteredAt(userApiRequest.getUnregisteredAt())
                            .setUnregisteredAt(userApiRequest.getRegisteredAt());

                    return user;
                })
                .map(user -> baseRepository.save(user))
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("NO DATA"));


    }

    @Override
    public Header delete(Long id) {

        Optional<User> optional = baseRepository.findById(id);

        return optional.map(user -> {
            baseRepository.delete(user);
            return Header.OK();
          }).orElseGet(() -> Header.ERROR("No Data"));


    }


    private Header<UserApiResponse> response(User user){

        UserApiResponse userApiResponse = UserApiResponse
                .builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) // todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        return Header.OK(userApiResponse);
    }

}
