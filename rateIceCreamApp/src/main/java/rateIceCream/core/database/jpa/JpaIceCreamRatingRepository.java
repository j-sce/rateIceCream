package rateIceCream.core.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rateIceCream.core.domain.IceCreamRating;

@Repository
public interface JpaIceCreamRatingRepository extends JpaRepository<IceCreamRating, Long> {

    @Query(value = "SELECT AVG(user_ice_cream_rating) FROM user_ice_cream_ratings WHERE ice_cream_id = ?", nativeQuery = true)
    Long getAvgRatingByIceCreamId(Long id);

}
