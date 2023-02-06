package com.javatechie.api.service;

//import com.javatechie.api.dto.UserRequest;
import com.javatechie.api.entity.User;
import com.javatechie.api.exception.UserFoundException;
import com.javatechie.api.exception.UserNotFoundException;
import com.javatechie.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;




    public User  saveUser(User user)throws UserFoundException {
        User user1=null;
            if(repository.existsFindByEmailAndMobile(user.getEmail(), user.getMobile())){
                throw new UserFoundException("user is already");
            }
            else {
               user1 =repository.save(user);
            }
            return user1;
    }


    public List<User> getALlUsers() {

        return repository.findAll();
    }


    public User getUser(int id) throws UserNotFoundException {
        User user= repository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }


    public ResponseEntity<?> updateByid(int id, User user) throws UserNotFoundException {
        User user1 = repository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User with ID :"+id+" Not Found!"));

        user.setUserId(user1.getUserId());
        repository.save(user);
        return ResponseEntity.ok().body(user);
    }
    public ResponseEntity<String> deleteById(int id) throws UserNotFoundException {
        User user = repository .findById(id).orElseThrow(()->new UserNotFoundException("User with ID :"+id+" Not Found!"));

        repository.deleteById(user.getUserId());
        return ResponseEntity.ok().body("User deleted with success!");
    }

}
