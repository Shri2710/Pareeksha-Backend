package com.exam.pariksha.repo;

import com.exam.pariksha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    public User findByUsername(String name);
}
