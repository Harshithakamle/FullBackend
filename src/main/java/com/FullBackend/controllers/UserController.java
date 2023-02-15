package com.FullBackend.controllers;

import com.FullBackend.payloads.UserDto;
import com.FullBackend.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/users")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateTheUser(@Valid @RequestBody UserDto userDto,@PathVariable("id") long id){
        UserDto userDto1 = userService.updateUser(userDto, id);
        return ResponseEntity.ok(userDto1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheUser(@PathVariable("id") long id){
        userService.deleteUser(id);
       return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("id") long id){
        UserDto userById = userService.getUserById(id);
        return ResponseEntity.ok(userById);
    }
}
