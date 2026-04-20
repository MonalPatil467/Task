package TaskManangement.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDTO {
    private Long categoryId;
    private String name;
    private String description;
}
