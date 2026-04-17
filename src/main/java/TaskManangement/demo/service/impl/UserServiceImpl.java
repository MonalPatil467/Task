package TaskManangement.demo.service.impl;

import TaskManangement.demo.Mapper.UserMapper;
import TaskManangement.demo.dto.UserDTO;
import TaskManangement.demo.entity.User;
import TaskManangement.demo.repository.UserRepository;
import TaskManangement.demo.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Transactional
@Builder
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // CREATE
    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = userMapper.toEntity(userDTO);

        User savedUser = userRepository.save(user);

        return userMapper.toDTO(savedUser);
    }

    // GET BY ID
    @Override
    public UserDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toDTO(user);
    }

    // GET ALL
    @Override
    public List<UserDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUserFromDto(userDTO, existingUser);

        User savedUser = userRepository.save(existingUser);

        return userMapper.toDTO(savedUser);
    }

    // DELETE
    @Override
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }


}