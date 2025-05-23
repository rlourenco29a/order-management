package com.exercise.sibs.controller;

import com.exercise.sibs.entity.User;
import com.exercise.sibs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping
    public List<User> all() { return repo.findAll(); }
    @PostMapping
    public User create(@RequestBody User u) { return repo.save(u); }
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) { return repo.findById(id).orElse(null); }

}
