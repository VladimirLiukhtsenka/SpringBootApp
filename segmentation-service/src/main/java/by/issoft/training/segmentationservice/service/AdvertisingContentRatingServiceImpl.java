package by.issoft.training.segmentationservice.service;

import by.issoft.training.domain.AdvertisingContentRatingConfig;
import by.issoft.training.domain.Category;
import by.issoft.training.dto.UserDto;
import by.issoft.training.repository.AdvertisingContentRatingConfigRepository;
import by.issoft.training.segmentationservice.dto.AdvertisingContentRatingDto;
import org.springframework.stereotype.Service;

@Service
public class AdvertisingContentRatingServiceImpl implements AdvertisingContentRatingService {
    private final AdvertisingContentRatingConfigRepository configRepository;
    private AdvertisingContentRatingConfig generalAudienceConfig;
    private AdvertisingContentRatingConfig parentalGuidanceConfig;
    private AdvertisingContentRatingConfig teenConfig;
    private AdvertisingContentRatingConfig matureAudiencesConfig;

    public AdvertisingContentRatingServiceImpl(AdvertisingContentRatingConfigRepository configRepository) {
        this.configRepository = configRepository;
        defineAdvertisingContentRatingConfigs();
    }

    @Override
    public AdvertisingContentRatingDto determineRating(UserDto userDto) {
        Integer userAge = userDto.getAge();
        AdvertisingContentRatingDto ratingDto = new AdvertisingContentRatingDto();

        ratingDto.setGeneralAudiences(userAge > generalAudienceConfig.getMinAge());
        ratingDto.setParentalGuidance(userAge > parentalGuidanceConfig.getMinAge());
        ratingDto.setTeen(userAge > teenConfig.getMinAge());
        ratingDto.setMatureAudiences(userAge > matureAudiencesConfig.getMinAge());

        return ratingDto;
    }

    private void defineAdvertisingContentRatingConfigs() {
        generalAudienceConfig = getAdvertisingContentRatingConfig(Category.GENERAL_AUDIENCE);
        parentalGuidanceConfig = getAdvertisingContentRatingConfig(Category.PARENTAL_GUIDANCE);
        teenConfig = getAdvertisingContentRatingConfig(Category.TEEN);
        matureAudiencesConfig = getAdvertisingContentRatingConfig(Category.MATURE_AUDIENCE);
    }

    private AdvertisingContentRatingConfig getAdvertisingContentRatingConfig(Category category) {
        return configRepository.findByCategory(category)
                .orElseThrow(IllegalArgumentException::new);
    }
}
