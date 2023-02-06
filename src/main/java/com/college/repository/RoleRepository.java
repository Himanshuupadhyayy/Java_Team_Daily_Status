package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entity.*;

public interface RoleRepository  extends JpaRepository<Role, Long>{	
}