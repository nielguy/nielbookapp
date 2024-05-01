package com.nielo.nielbook.nielbookapp.repository;

import com.nielo.nielbook.nielbookapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
