package TaskManangement.demo.repository;

import TaskManangement.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface CategoryRepository extends JpaRepository<Category , Long> {
}
