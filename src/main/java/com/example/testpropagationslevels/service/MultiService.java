package com.example.testpropagationslevels.service;

import com.example.testpropagationslevels.UserRepository;
import com.example.testpropagationslevels.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@AllArgsConstructor
public class MultiService {
    private UserServiceRequiresNew userServiceRequiresNew;
    private UserServiceRequired userServiceRequired;

    public void testPropagation() {
        try {
            var existedLastUser = userServiceRequiresNew.getCountOfUser();
            var user = User.builder().id(existedLastUser + 1).firstName("alice").build();
            userServiceRequiresNew.saveUser(user);
        } catch (RuntimeException e) {
            System.out.println("Exception occurred in requires new " + e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testReqPropagation() {
        try {
            var existedLastUser = userServiceRequired.getCountOfUser();
            var user = User.builder().id(existedLastUser + 1).firstName("alice").build();
            userServiceRequired.saveUser(user);
        } catch (RuntimeException e) {
            System.out.println("Exception occurred in required " + e);
        }
    }

}
