package com.codespring.newscms.domain.controllers;

import com.codespring.newscms.domain.models.User;
import com.codespring.newscms.domain.service.UserService;
import com.codespring.newscms.domain.vo.UserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(tags = "User", description = "User Api")
public class UserController {

    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

//    @GetMapping(value = "/{id}")
//    @ApiOperation(value = "Get User", notes = "Get user by ID")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "User found"),
//            @ApiResponse(code = 404, message = "User not found")
//    })
//    public ResponseEntity<User> findById(@PathVariable("id") String id){
//        return ResponseEntity.ok(userService.findById(id));
//    }

//    @GetMapping
//    @ApiOperation(value = "List users", notes = "List all users")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Found users"),
//            @ApiResponse(code = 404, message = "No users found")
//    })
//    public ResponseEntity<List<User>> findAll(){
//        return ResponseEntity.ok(userService.findAll());
//    }

//    @PostMapping
//    @ApiOperation(value = "Create user", notes = "Create a new user")
//    @ApiResponses({
//            @ApiResponse(code = 201, message = "User created"),
//            @ApiResponse(code = 400, message = "Invalid request")
//    })
//    public ResponseEntity<User> newUser(@RequestBody UserRequest userRequest){
//        return new ResponseEntity<>(userService.create(userRequest), HttpStatus.CREATED); // todo: do we need to do a check first here?
//    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @ApiOperation(value = "Delete user", notes = "Delete a user")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "User removed"),
//            @ApiResponse(code = 404, message = "User not found")
//    })
//    public void removeUser(@PathVariable("id") String id){
//        userService.delete(id);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id,User userRequest){
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }
}
