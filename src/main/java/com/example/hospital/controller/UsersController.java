package com.example.hospital.controller;

import com.example.hospital.model.Users;
import com.example.hospital.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.findUsers(null, null, null, null, null, null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Users>> getUsersById(@PathVariable Long id) {
        Optional<Optional<Users>> user = usersService.getUsersById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Users saveUser(@Valid @RequestBody Users user) {
        return usersService.saveUsers(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @Valid @RequestBody Users userDetails) {
        Optional<Users> updatedUser = usersService.updateUsers(id, userDetails);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            usersService.deleteUsersById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/find")
    public List<Users> findUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long userType
    ) {
        return usersService.findUsers(username, password, email, phone, userId, userType);
    }
}
