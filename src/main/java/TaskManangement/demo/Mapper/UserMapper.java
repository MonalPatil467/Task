package TaskManangement.demo.Mapper;


import TaskManangement.demo.dto.UserRequestDTO;
import TaskManangement.demo.dto.UserResponseDTO;
import TaskManangement.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // DTO → Entity (CREATE)
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO userRequestDTO);

    // Entity → DTO (RESPONSE)
    @Mapping(source = "id", target = "userId")
    UserResponseDTO toDTO(User user);

    // UPDATE existing entity from DTO
    @Mapping(target = "id", ignore = true)
    void updateUserFromDto(UserRequestDTO userRequestDTO, @MappingTarget User user);

}
