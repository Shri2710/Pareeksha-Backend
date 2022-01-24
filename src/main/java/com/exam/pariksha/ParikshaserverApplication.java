package com.exam.pariksha;

import com.exam.pariksha.model.Role;
import com.exam.pariksha.model.User;
import com.exam.pariksha.model.UserRole;
import com.exam.pariksha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ParikshaserverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ParikshaserverApplication.class, args);
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserService userService;


	@Override
	public void run(String... args) throws Exception {

		System.out.println("STARTING CODE");

//		User user =new User();
//
//		user.setFirstName("Shriganesh");
//		user.setLastName("Hegde");
//		user.setEmail("shri274023@gmail.com");
//		user.setPassword(bCryptPasswordEncoder.encode("shri"));
//		user.setPhone("8217895605");
//		user.setUsername("Shri2710");
//		user.setProfile("def.png");
//
//		Role role=new Role();
//
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> userRole=new HashSet<>();
//
//		UserRole usrrole=new UserRole();
//
//		usrrole.setRole(role);
//		usrrole.setUser(user);
//
//		userRole.add(usrrole);
//
//		this.userService.createUser(user,userRole);

	}
}
