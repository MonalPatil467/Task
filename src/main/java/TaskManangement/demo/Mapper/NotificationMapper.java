package TaskManangement.demo.Mapper;

import TaskManangement.demo.dto.NotificationRequestDTO;
import TaskManangement.demo.dto.NotificationResponseDTO;
import TaskManangement.demo.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface NotificationMapper {
    // Entity → Response
    @Mapping(source = "id", target = "notificationId")
    @Mapping(source = "user.id", target = "userId")
    NotificationResponseDTO toDTO(Notification notification);

    // Request → Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Notification toEntity(NotificationRequestDTO dto);

    // Update existing entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateNotificationFromDto(NotificationRequestDTO dto, @MappingTarget Notification entity);
}
