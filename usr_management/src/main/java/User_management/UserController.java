package User_management;


import User_management.DTO.UserRequestDTO;
import User_management.DTO.UserRespondDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/users")
@AllArgsConstructor

public class UserController {

    private  UserService userService;

    @GetMapping
    public List<UserRespondDTO> ReadAll(){
        return userService.getAll();
    }
    @PostMapping
    public void InsertNewUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.CreateNewUser(userRequestDTO);
    }
    @DeleteMapping("/{id}")
    public  void  DeleteUser(@PathVariable int id){
        userService.removeUser(id);
    }
    @PutMapping("/{id}")
    public  void  UpdateUsers(@PathVariable   int id , @RequestBody  User user){
        user.setId(id);
        userService.update(user);
    }

}
