package com.scheduler.demo.infrastructure.persistence.entities.user;

import com.scheduler.demo.infrastructure.persistence.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String name;
    
    private User(String email, String name) {
        this.email = email;
        this.name = name;
    }
    
    public static User create(String email, String name) {
        return new User(email, name);
    }
    
    public void updateName(String name) {
        this.name = name;
    }
} 