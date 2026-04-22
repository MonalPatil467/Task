package TaskManangement.demo.service.impl;

import TaskManangement.demo.Mapper.TaskMapper;
import TaskManangement.demo.dto.TaskRequestDTO;
import TaskManangement.demo.dto.TaskResponseDTO;
import TaskManangement.demo.entity.Category;
import TaskManangement.demo.entity.Task;
import TaskManangement.demo.entity.User;
import TaskManangement.demo.repository.CategoryRepository;
import TaskManangement.demo.repository.TaskRepository;
import TaskManangement.demo.repository.UserRepository;
import TaskManangement.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO dto) {
       Task task=taskMapper.toEntity(dto);
       User user=userRepository.findById(dto.getUserId()).orElseThrow(()->new RuntimeException("user not found with this id"));
       Category category=categoryRepository.findById(dto.getCategoryId()).orElseThrow(()->new RuntimeException("category not found"));
       task.setUser(user);
       task.setCategory(category);
       Task savedTask=taskRepository.save(task);

        // Step 5: Entity → DTO
        return taskMapper.toDto(savedTask);

    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        return taskMapper.toDto(task);
        //return null;
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
        //return List.of();
    }

    @Override
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {
        // Step 1: Fetch existing task
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // Step 2: Update simple fields
        taskMapper.updateTaskFromDto(dto, existingTask);

        // Step 3: Update relationships
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingTask.setUser(user);
        existingTask.setCategory(category);

        // Step 4: Save updated entity
        Task updatedTask = taskRepository.save(existingTask);

        // Step 5: Return response
        return taskMapper.toDto(updatedTask);
        //return null;
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }

        taskRepository.deleteById(id);

    }
}
