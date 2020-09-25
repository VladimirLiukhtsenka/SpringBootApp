package by.issoft.training.segmentationservice.service;

import by.issoft.training.dto.UserDto;
import by.issoft.training.factory.YamlPropertySourceFactory;
import by.issoft.training.segmentationservice.dto.AdvertisingContentRatingDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:advertisingcontentrating.yml")
public class AdvertisingContentRatingServiceImpl implements AdvertisingContentRatingService {
    @Value("${adContentRating.MinAge.generalAudiences}")
    private int minAgeForGeneralAudiences;
    @Value("${adContentRating.MinAge.parentalGuidance}")
    private int minAgeForParentalGuidance;
    @Value("${adContentRating.MinAge.teen}")
    private int minAgeForTeen;
    @Value("${adContentRating.MinAge.matureAudiences}")
    private int minAgeForMatureAudiences;

    @Override
    public AdvertisingContentRatingDto determineRating(UserDto userDto) {
        Integer userAge = userDto.getAge();
        AdvertisingContentRatingDto ratingDto = new AdvertisingContentRatingDto();

        ratingDto.setGeneralAudiences(userAge > minAgeForGeneralAudiences);
        ratingDto.setParentalGuidance(userAge > minAgeForParentalGuidance);
        ratingDto.setTeen(userAge > minAgeForTeen);
        ratingDto.setMatureAudiences(userAge > minAgeForMatureAudiences);

        return ratingDto;
    }
}
