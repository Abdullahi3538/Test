package User_management.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotNull(message = "Name is Required")
    private String name;

    @NotNull(message = "Username is Required")
    private String username;

    @NotNull(message = "Email is Required")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Password is Required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String passowrd;
}