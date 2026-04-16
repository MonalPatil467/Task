package TaskManangement.demo.service;

import TaskManangement.demo.dto.UserDTO;
import TaskManangement.demo.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}

