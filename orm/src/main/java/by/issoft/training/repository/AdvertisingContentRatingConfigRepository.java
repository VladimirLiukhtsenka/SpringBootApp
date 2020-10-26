package by.issoft.training.repository;

import by.issoft.training.domain.AdvertisingContentRatingConfig;
import by.issoft.training.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertisingContentRatingConfigRepository extends JpaRepository<AdvertisingContentRatingConfig, Long> {
    Optional<AdvertisingContentRatingConfig> findByCategory(Category category);
}
