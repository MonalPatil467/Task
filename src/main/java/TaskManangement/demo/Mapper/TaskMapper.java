package TaskManangement.demo.Mapper;

import TaskManangement.demo.dto.TaskRequestDTO;
import TaskManangement.demo.dto.TaskResponseDTO;
import TaskManangement.demo.entity.Task;
import TaskManangement.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapper {
@Mapping(source = "user.id",target = "userId")
@Mapping(source="category.id" , target="categoryId")
    TaskResponseDTO toDto(Task task);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "category", ignore = true)
    Task toEntity(TaskRequestDTO dto);

    // Update existing entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateTaskFromDto(TaskRequestDTO dto, @MappingTarget Task entity);


}
