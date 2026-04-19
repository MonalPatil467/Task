package TaskManangement.demo.dto;

import TaskManangement.demo.entity.Priority;
import TaskManangement.demo.entity.Status;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;

    private Status status;


    // Instead of full objects, use IDs
    private Long userId;
    private Long categoryId;
}
