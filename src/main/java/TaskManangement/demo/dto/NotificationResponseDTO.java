package TaskManangement.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponseDTO {
    private Long notificationId;
    private String message;
    private Boolean isRead;
    private Long userId;
}
