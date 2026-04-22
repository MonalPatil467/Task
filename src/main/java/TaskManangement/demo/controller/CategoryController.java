package TaskManangement.demo.controller;

import TaskManangement.demo.dto.NotificationRequestDTO;
import TaskManangement.demo.dto.NotificationResponseDTO;
import TaskManangement.demo.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoryController {
    private final NotificationService notificationService;

    // CREATE
    @PostMapping
    public ResponseEntity<NotificationResponseDTO> createNotification(
            @RequestBody NotificationRequestDTO dto
    ) {
        return ResponseEntity.ok(notificationService.createNotification(dto));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<NotificationResponseDTO>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponseDTO> getNotificationById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(notificationService.getNotificationById(id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok("Notification deleted successfully");
    }

    // 🔥 IMPORTANT FEATURE (don’t skip this)
    // MARK AS READ
    @PutMapping("/{id}/read")
    public ResponseEntity<NotificationResponseDTO> markAsRead(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.markAsRead(id));
    }
}
