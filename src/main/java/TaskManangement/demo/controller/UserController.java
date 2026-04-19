package TaskManangement.demo.controller;


import TaskManangement.demo.dto.UserRequestDTO;
import TaskManangement.demo.dto.UserResponseDTO;
import TaskManangement.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<UserRequestDTO> createUser(@RequestBody UserRequestDTO userDTO) {
        UserRequestDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserRequestDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDTO userDTO) {

        return ResponseEntity.ok(userService.updateUser(id, userDTO));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
