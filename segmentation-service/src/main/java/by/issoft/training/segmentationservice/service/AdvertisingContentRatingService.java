package by.issoft.training.segmentationservice.service;

import by.issoft.training.dto.UserDto;
import by.issoft.training.segmentationservice.dto.AdvertisingContentRatingDto;

public interface AdvertisingContentRatingService {
    AdvertisingContentRatingDto determineRating(UserDto userDto);
}
