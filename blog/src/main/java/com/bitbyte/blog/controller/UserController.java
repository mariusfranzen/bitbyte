package com.bitbyte.blog.controller;

import com.bitbyte.blog.model.User;
import com.bitbyte.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(path = "/api/users")
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    @ResponseBody
    public Info newUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        User user = new User(username, email, password); //TODO: Encrypt passwords

        user.setLevel(1);
        user.setPermission(User.permission.USER);
        user.setBanned(false);
        user.setDateOfCreation(new Date(System.currentTimeMillis()));

        Info info = new Info();

        try {
            userRepository.save(user);
            info.setStatus(Info.status.SUCCESS);
            info.setMessage("User successfully saved.");
            LOGGER.log(Level.INFO, "Saved user with id " + user.getId());
        } catch (Exception e) {
            info.setStatus(Info.status.ERROR);
            info.setMessage("Failed saving user.");
            info.setError(e.toString());
            LOGGER.log(Level.SEVERE, info.getMessage());
        }
        return info;
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
