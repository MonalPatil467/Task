package TaskManangement.demo.service.impl;

import TaskManangement.demo.Mapper.NotificationMapper;
import TaskManangement.demo.dto.NotificationRequestDTO;
import TaskManangement.demo.dto.NotificationResponseDTO;
import TaskManangement.demo.entity.Notification;
import TaskManangement.demo.entity.User;
import TaskManangement.demo.repository.NotificationRepository;
import TaskManangement.demo.repository.UserRepository;
import TaskManangement.demo.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final NotificationMapper notificationMapper;

    // CREATE
    @Override
    public NotificationResponseDTO createNotification(NotificationRequestDTO dto) {

        Notification notification = notificationMapper.toEntity(dto);


        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        notification.setUser(user);

        // optional: set timestamp
        notification.setSentAt(LocalDateTime.now());

        // default read status


        Notification saved = notificationRepository.save(notification);

        return notificationMapper.toDTO(saved);
    }

    // GET BY ID
    @Override
    public NotificationResponseDTO getNotificationById(Long id) {

        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        return notificationMapper.toDTO(notification);
    }

    // GET ALL
    @Override
    public List<NotificationResponseDTO> getAllNotifications() {

        return notificationRepository.findAll()
                .stream()
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public NotificationResponseDTO updateNotification(Long id, NotificationRequestDTO dto) {

        Notification existing = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notificationMapper.updateNotificationFromDto(dto, existing);


        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setUser(user);

        Notification updated = notificationRepository.save(existing);

        return notificationMapper.toDTO(updated);
    }

    // DELETE
    @Override
    public void deleteNotification(Long id) {

        if (!notificationRepository.existsById(id)) {
            throw new RuntimeException("Notification not found");
        }

        notificationRepository.deleteById(id);
    }
    @Override
    public NotificationResponseDTO markAsRead(Long id) {

        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setIsRead(true);

        Notification updated = notificationRepository.save(notification);

        return notificationMapper.toDTO(updated);
    }
}
