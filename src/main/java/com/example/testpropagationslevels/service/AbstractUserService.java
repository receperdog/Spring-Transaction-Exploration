package com.example.testpropagationslevels.service;

import com.example.testpropagationslevels.UserRepository;
import com.example.testpropagationslevels.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public abstract class AbstractUserService {
    protected final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public long getCountOfUser(){
        return userRepository.count();
    }
}
