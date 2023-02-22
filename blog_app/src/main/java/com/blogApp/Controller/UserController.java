package com.blogApp.Controller;

import com.blogApp.Payload.ApiResponses;
import com.blogApp.Payload.UserDTO;
import com.blogApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO createUserDto = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Integer userId){
       UserDTO updatedUser = this.userService.updateUser(userDTO, userId);
       return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponses> deleteUser(@PathVariable Integer userId){
         this.userService.deleteUser(userId);
       return new ResponseEntity(new ApiResponses("user deleted", true), HttpStatus.OK );
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUser(){
  return  ResponseEntity.ok(this.userService.getAllUser());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
