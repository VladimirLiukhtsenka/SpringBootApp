package by.issoft.training.segmentationservice.rest;

import by.issoft.training.dto.UserDto;
import by.issoft.training.segmentationservice.dto.AdvertisingContentRatingDto;
import by.issoft.training.segmentationservice.service.AdvertisingContentRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/AdvertisingContentRating")
@RequiredArgsConstructor
public class AdvertisingContentRatingRestController {
    private final AdvertisingContentRatingService advertisingContentRatingService;

    @PostMapping
    public AdvertisingContentRatingDto getAdvertisingContentRating(@RequestBody UserDto userDto) {
        return advertisingContentRatingService.determineRating(userDto);
    }
}
