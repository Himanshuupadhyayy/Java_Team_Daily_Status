package com.javatechie.api.controller;
import com.javatechie.api.entity.User;
import com.javatechie.api.exception.UserFoundException;
import com.javatechie.api.exception.UserNotFoundException;
import com.javatechie.api.repository.UserRepository;
import com.javatechie.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/adduser")
    public ResponseEntity<?> saveUser(@RequestBody @Valid User user) throws UserFoundException {
           // return new ResponseEntity.ok(userService.saveUser(user));
        User user1=null;
        try{
         user1   =this.userService.saveUser(user);
        }catch (UserFoundException ex){
            ex.printStackTrace();
         //   throw new UserFoundException("user is already registered with us");
            return ResponseEntity.badRequest().body("user is already with us !!!");
             }
        catch (Exception e){
            throw new UserFoundException("user is already registered with us");
        }
        return ResponseEntity.ok(user1);
        }


    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getALlUsers());
    }

    @GetMapping("/getAll/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) throws UserNotFoundException {
        return  this.userService.deleteById(id);

    }
   @PutMapping("/update/{id}")
    public  ResponseEntity<?> updateUser( @PathVariable int id,@RequestBody User user) throws UserNotFoundException {
        return this.userService.updateByid(id,user);
    }

}
