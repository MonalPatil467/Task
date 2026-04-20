package TaskManangement.demo.dto;

import lombok.*;
import org.aspectj.bridge.IMessage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequestDTO {
    private String description;

    private String name;
}
