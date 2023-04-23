package rateIceCream.core.database;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.domain.UserIceCreamRating;


@Component
@Transactional
public class IceCreamRatingRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(UserIceCreamRating userIceCreamRating) {
        sessionFactory.getCurrentSession().save(userIceCreamRating);
    }

    public UserIceCreamRating getById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(UserIceCreamRating.class, id);
    }

}
