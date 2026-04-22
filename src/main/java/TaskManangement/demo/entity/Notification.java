package TaskManangement.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime sentAt;

    private boolean sent;

    private boolean isRead=false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setIsRead(boolean b) {
    }
}
