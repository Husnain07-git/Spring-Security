package com.example.SS.demo.Controller;

import com.example.SS.demo.Config.GenericResponse;
import com.example.SS.demo.Entity.User;
import com.example.SS.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public GenericResponse<User> createUser(@RequestBody User user) {
        try {
            User user1 = userService.createUser(user);
            return GenericResponse.success(user1);
        } catch (Exception e) {
            return GenericResponse.failed(null, "201", e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public User createUser(@PathVariable Long id) {
        try {
            User user1 = userService.getById(id);
            return user1;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/get-users")
    public GenericResponse<List<User>> createUser() {
        try {
            List<User> user1 = userService.getUsers();
            return GenericResponse.success(user1);
        } catch (Exception e) {
            return GenericResponse.failed(null, "201", e.getMessage());
        }
    }

}
