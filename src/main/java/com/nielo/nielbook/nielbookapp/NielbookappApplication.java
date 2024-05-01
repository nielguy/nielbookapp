package com.nielo.nielbook.nielbookapp;

import com.nielo.nielbook.nielbookapp.entity.Role;
import com.nielo.nielbook.nielbookapp.entity.User;
import com.nielo.nielbook.nielbookapp.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NielbookappApplication {

	private PasswordEncoder passwordEncoder;

	private UserRepository userRepository;

	@Autowired
	public NielbookappApplication(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		this.passwordEncoder=passwordEncoder;
		this.userRepository=userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(NielbookappApplication.class, args);
	}

	@PostConstruct
	protected void init() {
		List<Role> roleList = new ArrayList<>();
		roleList.add(createRole("USER","User role"));
		roleList.add(createRole("ADMIN", "Admin role"));
		User user = new User();
		user.setUsername("niel");
		user.setFirstName("niel");
		user.setLastName("b");
		user.setPassword(passwordEncoder.encode("password"));
		user.setEnabled(true);
		user.setRoles(roleList);
		userRepository.save(user);
	}

	private Role createRole(String roleCode, String roleDescription) {
		Role role = new Role();
		role.setRoleCode(roleCode);
		role.setRoleDescription(roleDescription);
		return role;
	}
}
