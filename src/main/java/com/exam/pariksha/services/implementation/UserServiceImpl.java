package com.exam.pariksha.services.implementation;

import com.exam.pariksha.model.User;
import com.exam.pariksha.model.UserRole;
import com.exam.pariksha.repo.RoleRepo;
import com.exam.pariksha.repo.UserRepo;
import com.exam.pariksha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception{


        User local=this.userRepo.findByUsername(user.getUsername());

        if(local!=null){

            System.out.println("User already present");

            throw new Exception("User already present");
        }else{

            for(UserRole ur: userRoles){
                roleRepo.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local=this.userRepo.save(user);
        }
        return local;
    }

    @Override
    public User getUserByName(String name) {
        return this.userRepo.findByUsername(name);
    }

}
