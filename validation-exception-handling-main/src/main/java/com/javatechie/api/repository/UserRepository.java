package com.javatechie.api.repository;

import com.javatechie.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Integer> {
   public User findByUserId(int id);
//   Optional<User> findByEmail(String email);
//   List<User> findByMobile(String mobile);
boolean existsFindByEmailAndMobile(String email, String mobile);
   //public User findByName(String name);
}
