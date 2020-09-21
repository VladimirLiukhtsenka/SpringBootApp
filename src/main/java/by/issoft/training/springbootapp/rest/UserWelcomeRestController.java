package by.issoft.training.springbootapp.rest;

import by.issoft.training.springbootapp.dto.UserDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/welcome")
public class UserWelcomeRestController {

    @PostMapping("/{name}")
    public UserDto welcome(@PathVariable("name") String name) {
        UserDto userDto = new UserDto();
        userDto.setName(name);

        return userDto;
    }
}
