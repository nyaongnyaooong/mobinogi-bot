package com.scheduler.demo.domain.user.presentation.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.demo.domain.user.application.UserService;
import com.scheduler.demo.domain.user.presentation.dto.UserDto;
import com.scheduler.demo.infrastructure.persistence.entities.user.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("/test/{email}")
    public ResponseEntity<UserDto.Response> getUser(@PathVariable String email) {
        System.out.println("emailemailemailemailemailemailemailemailemailemailemailemailemailemail: " + email);
        System.out.println("--------------------------------");
        System.out.println("-----------------------------123---");
        System.out.println("-----------------------------34---");
        System.out.println("----------------------------5432----");
        System.out.println("-------------------------ㄱ23-------");
        System.out.println("----------------------34ㅎ3----------");
        System.out.println("----------------------ㄱ3----------");
        System.out.println("-----------------------345---------");

        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(UserDto.Response.from(user));
    }

    // @PostMapping
    // public ResponseEntity<UserDto.CreateResponse> createUser(@RequestBody UserDto.CreateRequest request) {
    //     User user = userService.createUser(request.getEmail(), request.getName());
    //     return ResponseEntity.ok(UserDto.CreateResponse.from(user));
    // }
    
    // @GetMapping("/{email}")
    // public ResponseEntity<UserDto.Response> getUser(@PathVariable String email) {
    //     User user = userService.getUserByEmail(email);
    //     return ResponseEntity.ok(UserDto.Response.from(user));
    // }
    
    // @PatchMapping("/{email}/name")
    // public ResponseEntity<Void> updateUserName(
    //         @PathVariable String email,
    //         @RequestBody UserDto.UpdateNameRequest request) {
    //     userService.updateUserName(email, request.getName());
    //     return ResponseEntity.ok().build();
    // }
} 