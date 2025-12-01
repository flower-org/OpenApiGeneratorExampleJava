package com.flower.service.controller;

import com.flower.service.api.model.UserCreateRequest;
import com.flower.service.api.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.flower.service.api.controller.UserApi;

@Controller
public class UserApiController implements UserApi {

    private final NativeWebRequest request;

    @Autowired
    public UserApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserCreateRequest userCreateRequest) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<UserDto>> getUsers() throws Exception {
        List<UserDto> users = new ArrayList<>();
        users.add(userOf(1, OffsetDateTime.now(), "ivan@example.com", "Ivan Petrov"));
        users.add(userOf(2, OffsetDateTime.now(), "john@example.com", "John Doe"));

        return ResponseEntity.ok(users);
    }

    public static UserDto userOf(Integer id, OffsetDateTime createdAt, String email, String name) {
        UserDto user = new UserDto();
        user.setId(id);
        user.setCreatedAt(createdAt);
        user.setEmail(email);
        user.setName(name);
        return user;
    }
}
