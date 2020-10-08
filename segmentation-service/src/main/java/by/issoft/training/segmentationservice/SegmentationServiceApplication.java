package by.issoft.training.segmentationservice;

import by.issoft.training.segmentationservice.config.AdvertisingContentRatingMinAgeConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AdvertisingContentRatingMinAgeConfig.class)
public class SegmentationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SegmentationServiceApplication.class, args);
    }

}
