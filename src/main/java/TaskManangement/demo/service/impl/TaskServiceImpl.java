package TaskManangement.demo.service.impl;

import TaskManangement.demo.dto.TaskRequestDTO;
import TaskManangement.demo.dto.TaskResponseDTO;
import TaskManangement.demo.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public TaskResponseDTO createTask(TaskRequestDTO dto) {

        return null;
    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {
        return null;
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return List.of();
    }

    @Override
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
