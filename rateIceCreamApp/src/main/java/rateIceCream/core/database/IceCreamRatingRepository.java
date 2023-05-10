package rateIceCream.core.database;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.domain.IceCreamRating;


@Component
@Transactional
public class IceCreamRatingRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(IceCreamRating iceCreamRating) {
        sessionFactory.getCurrentSession().save(iceCreamRating);
    }

    public IceCreamRating getById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(IceCreamRating.class, id);
    }

}
