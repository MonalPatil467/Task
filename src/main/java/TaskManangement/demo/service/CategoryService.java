package TaskManangement.demo.service;

import TaskManangement.demo.dto.CategoryRequestDTO;
import TaskManangement.demo.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO dto);

    CategoryResponseDTO getCategoryById(Long id);

    List<CategoryResponseDTO> getAllCategories();

   // CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto);

    // UPDATE
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto);

    void deleteCategory(Long id);
}
