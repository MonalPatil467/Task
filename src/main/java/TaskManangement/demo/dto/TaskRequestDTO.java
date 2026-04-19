package TaskManangement.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskRequestDTO {
    private String title;
    private String description;
    private String status;
    private Long userId;
    private Long categoryId;
}
