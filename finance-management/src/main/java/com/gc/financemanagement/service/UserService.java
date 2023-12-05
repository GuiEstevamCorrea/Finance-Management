package com.gc.financemanagement.service;

import com.gc.financemanagement.model.UserModel;
import com.gc.financemanagement.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserModel saveUser(@NotNull UserModel userModel) {
        if (userRepository.existsByCpf(userModel.getCpf())) {
            throw new RuntimeException("There is already a registered user with the same CPF");
        }
        userModel = userRepository.save(userModel);
        return userModel;
    }

    public List<UserModel> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<UserModel> findByUserId(UUID userId){
        return userRepository.findById(userId);
    }

    @Transactional
    public void deleteUser(UserModel userModel) {
        userRepository.delete(userModel);
    }
}
