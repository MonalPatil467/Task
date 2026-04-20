package TaskManangement.demo.Mapper;

import TaskManangement.demo.dto.CategoryRequestDTO;
import TaskManangement.demo.dto.CategoryResponseDTO;
import TaskManangement.demo.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {
    @Mapping(source = "id", target = "categoryId")
    CategoryResponseDTO toDTO(Category category);

    // Request → Entity
    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryRequestDTO dto);

    // Update existing entity
    @Mapping(target = "id", ignore = true)
    void updateCategoryFromDto(CategoryRequestDTO dto, @MappingTarget Category entity);
}
