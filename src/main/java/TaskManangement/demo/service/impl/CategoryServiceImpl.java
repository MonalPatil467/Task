package TaskManangement.demo.service.impl;

import TaskManangement.demo.Mapper.CategoryMapper;
import TaskManangement.demo.dto.CategoryRequestDTO;
import TaskManangement.demo.dto.CategoryResponseDTO;
import TaskManangement.demo.entity.Category;
import TaskManangement.demo.repository.CategoryRepository;
import TaskManangement.demo.service.CategoryService;
//import TaskManagement.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    // CREATE
    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {

        Category category = categoryMapper.toEntity(dto);

        Category saved = categoryRepository.save(category);

        return categoryMapper.toDTO(saved);
    }

    // GET BY ID
    @Override
    public CategoryResponseDTO getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return categoryMapper.toDTO(category);
    }

    // GET ALL
    @Override
    public List<CategoryResponseDTO> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto) {

        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        categoryMapper.updateCategoryFromDto(dto, existing);

        Category updated = categoryRepository.save(existing);

        return categoryMapper.toDTO(updated);
    }

    // DELETE
    @Override
    public void deleteCategory(Long id) {

        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }

        categoryRepository.deleteById(id);
    }
}
