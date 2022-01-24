package com.exam.pariksha.Controller;


import com.exam.pariksha.model.Role;
import com.exam.pariksha.model.User;
import com.exam.pariksha.model.UserRole;
import com.exam.pariksha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {


        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> userRole=new HashSet<>();
        Role role=new Role();

        role.setRoleName("NORMAL");

        UserRole userrole=new UserRole();

        userrole.setUser(user);
        userrole.setRole(role);

        userRole.add(userrole);

        return userService.createUser(user,userRole);
    }

    @GetMapping("/{username}")
    public User createUser(@PathVariable("username") String username) throws Exception {

        return userService.getUserByName(username);
    }
}
