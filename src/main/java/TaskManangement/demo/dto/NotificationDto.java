package TaskManangement.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDto {
    private Long id;

    private String message;

    private Boolean sent;

    private LocalDateTime createdAt;

    // Use IDs instead of full objects
    private Long userId;
    private Long taskId;
}
