package by.issoft.training.segmentationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisingContentRatingDto {
    private Boolean generalAudiences;
    private Boolean parentalGuidance;
    private Boolean teen;
    private Boolean matureAudiences;
}
