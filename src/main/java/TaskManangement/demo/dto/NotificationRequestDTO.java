package TaskManangement.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequestDTO {
    private String message;

   // @NotNull(message = "User ID is required")
    private Long userId;

    private Boolean isRead; // o
}
