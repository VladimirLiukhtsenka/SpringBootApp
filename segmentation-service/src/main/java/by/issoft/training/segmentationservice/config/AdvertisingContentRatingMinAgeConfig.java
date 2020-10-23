package by.issoft.training.segmentationservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "advertising.contentrating.minage")
@Data
public class AdvertisingContentRatingMinAgeConfig {
    private int generalAudiences;
    private int parentalGuidance;
    private int teen;
    private int matureAudiences;
}
