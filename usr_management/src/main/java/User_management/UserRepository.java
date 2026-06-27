package User_management;

import User_management.DTO.UserRequestDTO;
import User_management.DTO.UserRespondDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@AllArgsConstructor
@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<UserRespondDTO> Finall(){
        String sql = "Select * from users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserRespondDTO.class));
    }


    public  void  AddNewUser(UserRequestDTO userRequestDTO){
        String sql = """
        INSERT INTO users(name, username, email, passowrd)
        VALUES(:name, :username, :email, :passowrd)
    """;        MapSqlParameterSource parms = new MapSqlParameterSource().
                addValue("name", userRequestDTO.getName()).
                addValue("username", userRequestDTO.getUsername()).
                addValue("email",userRequestDTO.getEmail()).
                addValue("passowrd",userRequestDTO.getPassowrd());
        namedParameterJdbcTemplate.update(sql,parms);
    }

    public  void  delete (int id){
        String sql = "DELETE FROM USERS WHERE ID = :ID";
        MapSqlParameterSource pram = new MapSqlParameterSource().
                addValue("ID", id);
        namedParameterJdbcTemplate.update(sql,pram);
    }

    public void updateUsers(User user) {

        String sql = "UPDATE users SET " +
                "name = :name, " +
                "username = :username, " +
                "email = :email " +
                "WHERE id = :id";

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("name", user.getName())
                .addValue("username", user.getUsername())
                .addValue("email", user.getEmail());

        namedParameterJdbcTemplate.update(sql, param);
    }

}
