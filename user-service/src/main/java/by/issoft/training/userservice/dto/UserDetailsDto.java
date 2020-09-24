package by.issoft.training.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
    private String name;
    private Integer age;
    private Boolean generalAudiences;
    private Boolean parentalGuidance;
    private Boolean teen;
    private Boolean matureAudiences;
}
