package com.example.testpropagationslevels.service;

import com.example.testpropagationslevels.repository.UserRepository;
import com.example.testpropagationslevels.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceRequiresNew extends AbstractUserService {

    private final UserRepository userRepository;

    public UserServiceRequiresNew(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public long getCountOfUser() {
        return userRepository.count();
    }
}
