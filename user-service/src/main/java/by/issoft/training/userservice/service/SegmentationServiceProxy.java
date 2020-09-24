package by.issoft.training.userservice.service;

import by.issoft.training.dto.UserDto;
import by.issoft.training.userservice.dto.UserDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "segmentation-service", url = "localhost:81")
public interface SegmentationServiceProxy {
    @PostMapping("/api/AdvertisingContentRating")
    UserDetailsDto getAdvertisingContentRating(@RequestBody UserDto userDto);
}
