package by.issoft.training.segmentationservice.service;

import by.issoft.training.dto.UserDto;
import by.issoft.training.segmentationservice.dto.AdvertisingContentRatingDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:advertisingcontentrating.properties")
public class AdvertisingContentRatingServiceImpl implements AdvertisingContentRatingService {
    @Value("${ad.content.min.age.generalAudiences}")
    private int minAgeForGeneralAudiences;
    @Value("${ad.content.min.age.parentalGuidance}")
    private int minAgeForParentalGuidance;
    @Value("${ad.content.min.age.teen}")
    private int minAgeForTeen;
    @Value("${ad.content.min.age.matureAudiences}")
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
