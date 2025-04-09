package com.scheduler.demo.domain.user.application;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scheduler.demo.infrastructure.persistence.entities.user.User;
import com.scheduler.demo.infrastructure.persistence.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createUser(String email, String name) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }
        return userRepository.save(User.create(email, name));
    }

    public User getUserByEmail(String email) {

        Optional<User> user = userRepository.findByEmail(email);

        if (!user.isPresent()) {
            throw new RuntimeException("존재하지 않는 사용자입니다.");
        }

        return user.get();
    }

    @Transactional
    public void updateUserName(String email, String newName) {
        User user = getUserByEmail(email);
        user.updateName(newName);
    }
}
