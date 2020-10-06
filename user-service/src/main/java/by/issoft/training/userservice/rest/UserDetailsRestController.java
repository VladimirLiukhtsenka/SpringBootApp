package by.issoft.training.userservice.rest;

import by.issoft.training.dto.UserDto;
import by.issoft.training.userservice.dto.UserDetailsDto;
import by.issoft.training.userservice.service.SegmentationServiceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/userDetails")
@RequiredArgsConstructor
public class UserDetailsRestController {
    private final SegmentationServiceProxy segmentationServiceProxy;

    @GetMapping("name/{name}/age/{age}")
    public UserDetailsDto getUserDetails(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        UserDetailsDto userDetailsDto = segmentationServiceProxy.getAdvertisingContentRating(new UserDto(name, age));
        userDetailsDto.setAge(age);
        userDetailsDto.setName(name);

        return userDetailsDto;
    }
}
