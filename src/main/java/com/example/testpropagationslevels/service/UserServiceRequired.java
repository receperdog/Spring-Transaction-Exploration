package com.example.testpropagationslevels.service;

import com.example.testpropagationslevels.repository.UserRepository;
import com.example.testpropagationslevels.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceRequired extends AbstractUserService {

    private final UserRepository userRepository;

    public UserServiceRequired(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
    public void saveUser(User user) {
        userRepository.save(user);
    }
    public long getCountOfUser() {
        return userRepository.count();
    }
}

