package TaskManangement.demo.Mapper;

import TaskManangement.demo.dto.TaskDTO;
import TaskManangement.demo.entity.Task;

public class TaskMapper {

    public static TaskDTO toDTO(Task task) {
        if (task == null) return null;

        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .status(task.getStatus())
                .priority(task.getPriority())
                .userId(task.getUser() != null ? task.getUser().getId() : null)
                .categoryId(task.getCategory() != null ? task.getCategory().getId() : null)
                .build();
    }

    public static Task toEntity(TaskDTO dto) {
        if (dto == null) return null;

        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .deadline(dto.getDeadline())
                .status(dto.getStatus())
                .priority(dto.getPriority())
                .build();
    }
}
