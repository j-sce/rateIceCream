package rateIceCream.core.database.non_jpa;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.domain.IceCreamRating;

import java.util.List;


//@Component
//@Transactional
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

    public Long getAvgRatingByIceCreamId(Long id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT r FROM IceCreamRating r WHERE iceCream.id = :id");
        query.setParameter("id", id);
        List<IceCreamRating> iceCreamRatings = query.getResultList();
        Long sum = 0L;
        for (IceCreamRating iceCreamRating : iceCreamRatings) {
            sum += iceCreamRating.getRating();
        }
        return sum / iceCreamRatings.size();
    }


}
