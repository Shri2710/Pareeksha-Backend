package com.exam.pariksha.repo;

import com.exam.pariksha.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
