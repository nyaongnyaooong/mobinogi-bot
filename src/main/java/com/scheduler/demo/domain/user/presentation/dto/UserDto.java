package com.scheduler.demo.domain.user.presentation.dto;

import com.scheduler.demo.infrastructure.persistence.entities.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {

        private String email;
        private String name;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        private Long id;
        private String email;
        private String name;

        public static Response from(User user) {
            return new Response(user.getId(), user.getEmail(), user.getName());
        }
    }

    // @Getter
    // @NoArgsConstructor
    // @AllArgsConstructor
    // public static class UpdateNameRequest {
    //     private String name;
    // }
    // @Getter
    // @NoArgsConstructor
    // @AllArgsConstructor
    // public static class Response {
    //     private Long id;
    //     private String email;
    //     private String name;
    //     public static Response from(User user) {
    //         return new Response(user.getId(), user.getEmail(), user.getName());
    //     }
    // }
    // @Getter
    // @NoArgsConstructor
    // @AllArgsConstructor
    // public static class CreateResponse {
    //     private Long id;
    //     private String email;
    //     private String name;
    //     public static CreateResponse from(User user) {
    //         return new CreateResponse(user.getId(), user.getEmail(), user.getName());
    //     }
    // }
}
