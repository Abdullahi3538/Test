package User_management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRespondDTO {
    private  int id ;
    private  String name;
    private  String username;
    private  String email;
}
