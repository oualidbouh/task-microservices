package task.io.gateway.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.io.gateway.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable Long id){
        return new UserDTO(16L,"Oualid");
    }
}
