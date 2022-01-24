package com.exam.pariksha.services;

import com.exam.pariksha.model.User;
import com.exam.pariksha.model.UserRole;

import java.util.Set;

public interface UserService {


    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUserByName(String name);
}
