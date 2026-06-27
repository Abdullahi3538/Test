package User_management;

import User_management.DTO.UserRequestDTO;
import User_management.DTO.UserRespondDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private  UserRepository userRepository;

    public List<UserRespondDTO> getAll(){
        return userRepository.Finall();
    }

    public  void  CreateNewUser(UserRequestDTO userRequestDTO){
        userRepository.AddNewUser(userRequestDTO);
    }

    public  void removeUser(int id){
        userRepository.delete(id);
    }
    public  void update(User user){
        userRepository.updateUsers(user);
    }
}
