package com.example.SS.demo.Service;

import com.example.SS.demo.Entity.User;
import com.example.SS.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        User newUser = new User();
        newUser.setCreatedAt(LocalDate.now());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmailAddress(user.getEmailAddress());
        newUser.setRoles(user.getRoles());
        User save = userRepository.save(newUser);
        return save;
    }

    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User u = user.get();
        return u;
    }

    public List<User> getUsers() {
        List<User> all = userRepository.findAll();
        if (!all.isEmpty()) {
            return all;
        }
        throw new RuntimeException("No users found");
    }
}
