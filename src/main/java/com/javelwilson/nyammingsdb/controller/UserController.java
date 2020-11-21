package com.javelwilson.nyammingsdb.controller;

import com.javelwilson.nyammingsdb.dto.UserDto;
import com.javelwilson.nyammingsdb.model.RestaurantResponseModel;
import com.javelwilson.nyammingsdb.model.UserRequestModel;
import com.javelwilson.nyammingsdb.model.UserResponseModel;
import com.javelwilson.nyammingsdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public UserResponseModel getUser(@PathVariable String id) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = userService.getUserById(id);

        UserResponseModel userResponseModel = modelMapper.map(userDto, UserResponseModel.class);
        return userResponseModel;
    }

    @GetMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public List<UserResponseModel> getUsers(@RequestParam(value="page", defaultValue = "0") int page,
                                            @RequestParam(value="limit", defaultValue = "25") int limit ) {
        ModelMapper modelMapper = new ModelMapper();
        List<UserDto> usersDto = userService.getUsers(page, limit);

        Type listType = new TypeToken<List<UserResponseModel>>() {
        }.getType();
        List<UserResponseModel> usersResponseModel = modelMapper.map(usersDto, listType);
        return usersResponseModel;
    }

    @DeleteMapping(path = "/{userId}", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public void deleteUser(@PathVariable String userId) {
        ModelMapper modelMapper = new ModelMapper();
        userService.deleteUser(userId);
    }

    @PatchMapping(path = "/{userId}", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public UserResponseModel updateUser(@PathVariable String userId, @RequestBody UserRequestModel userRequestModel) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);

        userDto = userService.updateUser(userId, userDto);

        UserResponseModel userResponseModel = modelMapper.map(userDto, UserResponseModel.class);
        return userResponseModel;
    }

    @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public UserResponseModel createUser(@RequestBody UserRequestModel userRequestModel) {
        UserResponseModel userResponseModel = new UserResponseModel();

        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);

        userDto = userService.createUser(userDto);
        userResponseModel = modelMapper.map(userDto, UserResponseModel.class);

        return userResponseModel;
    }
}
