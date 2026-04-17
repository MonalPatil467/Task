package TaskManangement.demo.Mapper;


import TaskManangement.demo.dto.UserDTO;
import TaskManangement.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
      UserDTO toDTO(User user);
     User toEntity(UserDTO userDTO);
    void updateUserFromDto(UserDTO dto, @MappingTarget User entity);

}
