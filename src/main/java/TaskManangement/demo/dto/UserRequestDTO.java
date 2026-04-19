package TaskManangement.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserRequestDTO {
    //@NotBlank(message = "Name is required")
    private String name;

   // @Email(message = "Invalid email format")
    //@NotBlank(message = "Email is required")
    private String email;

}
