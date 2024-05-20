package com.myprojects.usermanagementsystemdto.repository;

import com.myprojects.usermanagementsystemdto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
