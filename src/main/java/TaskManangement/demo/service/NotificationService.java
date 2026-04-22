package TaskManangement.demo.service;

import TaskManangement.demo.dto.NotificationRequestDTO;
import TaskManangement.demo.dto.NotificationResponseDTO;

import java.util.List;

public interface NotificationService {
   // NotificationResponseDTO createNotification(NotificationRequestDTO dto);

    // CREATE
   // NotificationResponseDTO createNotification(NotificationRequestDTO dto);

    // CREATE
    NotificationResponseDTO createNotification(NotificationRequestDTO dto);

    NotificationResponseDTO getNotificationById(Long id);

    List<NotificationResponseDTO> getAllNotifications();

    NotificationResponseDTO updateNotification(Long id, NotificationRequestDTO dto);

    void deleteNotification(Long id);
    NotificationResponseDTO markAsRead(Long id);
}
