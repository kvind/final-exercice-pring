package com.example.finalexercice.controller;

import com.example.finalexercice.dao.AppUserRepository;
import com.example.finalexercice.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/users")
    public List<AppUser> getUsers() {
        return this.appUserRepository.findAll();
    }

    @PostMapping("/users")
    public AppUser createUser(@Valid @RequestBody AppUser user) {
        String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);

        return appUserRepository.save(user);
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "username") String username) {
        AppUser appUser = this.appUserRepository.findByUsername(username);
        appUserRepository.delete(appUser);
        return ResponseEntity.ok().build();
    }
}
