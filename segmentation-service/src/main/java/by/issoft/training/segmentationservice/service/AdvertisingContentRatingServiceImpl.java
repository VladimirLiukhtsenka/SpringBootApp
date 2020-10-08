package by.issoft.training.segmentationservice.service;

import by.issoft.training.dto.UserDto;
import by.issoft.training.segmentationservice.config.AdvertisingContentRatingMinAgeConfig;
import by.issoft.training.segmentationservice.dto.AdvertisingContentRatingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertisingContentRatingServiceImpl implements AdvertisingContentRatingService {
    private final AdvertisingContentRatingMinAgeConfig minAgeConfig;

    @Override
    public AdvertisingContentRatingDto determineRating(UserDto userDto) {
        Integer userAge = userDto.getAge();
        AdvertisingContentRatingDto ratingDto = new AdvertisingContentRatingDto();

        ratingDto.setGeneralAudiences(userAge > minAgeConfig.getGeneralAudiences());
        ratingDto.setParentalGuidance(userAge > minAgeConfig.getParentalGuidance());
        ratingDto.setTeen(userAge > minAgeConfig.getTeen());
        ratingDto.setMatureAudiences(userAge > minAgeConfig.getMatureAudiences());

        return ratingDto;
    }
}
