package by.issoft.training.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "ad_content_rating_config")
public class AdvertisingContentRatingConfig extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Column(name = "min_age")
    private Integer minAge;
}
