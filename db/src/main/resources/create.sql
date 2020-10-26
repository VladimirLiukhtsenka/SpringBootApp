DROP DATABASE IF EXISTS segmentation;
CREATE SCHEMA segmentation DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

CREATE TABLE ad_content_rating_config
(
    id       BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(45) NOT NULL,
    min_age  INT         NOT NULL
) ENGINE = InnoDB;

insert into ad_content_rating_config (category, min_age)
values ('GENERAL_AUDIENCE', 4);

insert into ad_content_rating_config (category, min_age)
values ('PARENTAL_GUIDANCE', 9);

insert into ad_content_rating_config (category, min_age)
values ('TEEN', 12);

insert into ad_content_rating_config (category, min_age)
values ('MATURE_AUDIENCE', 17);
