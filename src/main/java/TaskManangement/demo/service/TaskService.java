package TaskManangement.demo.service;

import TaskManangement.demo.Mapper.TaskMapper;
import TaskManangement.demo.dto.TaskRequestDTO;
import TaskManangement.demo.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {
TaskResponseDTO createTask(TaskRequestDTO dto);
TaskResponseDTO getTaskById(Long id);
List<TaskResponseDTO> getAllTasks();
TaskResponseDTO updateTask(Long id,TaskRequestDTO taskRequestDTO);
    void deleteUser(Long id);

}
