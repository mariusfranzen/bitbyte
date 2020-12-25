package com.bitbyte.blog.controller;

import com.bitbyte.blog.model.User;
import com.bitbyte.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/users")
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    @ResponseBody
    public String newUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        User user = new User(username, email, password); //TODO: Encrypt passwords

        user.setLevel(1);
        user.setPermission(User.permission.USER);
        user.setBanned(false);
        user.setDateOfCreation(new Date(System.currentTimeMillis()));

        userRepository.save(user);
        return user + "\n\nThis user has been saved!";
    }

    @GetMapping(path = "/id")
    @ResponseBody
    public Optional<User> getUserById(@RequestParam Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
