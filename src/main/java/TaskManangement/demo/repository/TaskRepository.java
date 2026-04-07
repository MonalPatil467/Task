package TaskManangement.demo.repository;

import TaskManangement.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task , Long> {
}
