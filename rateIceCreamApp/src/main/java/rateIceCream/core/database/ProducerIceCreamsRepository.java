package rateIceCream.core.database;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.domain.ProducerIceCreams;

//@Component
//@Transactional
public class ProducerIceCreamsRepository {

    @Autowired
    SessionFactory sessionFactory;

    public void save(ProducerIceCreams producerIceCreams) {
        sessionFactory.getCurrentSession().save(producerIceCreams);
    }

    public ProducerIceCreams findById(Long id) {
        return sessionFactory.getCurrentSession().get(ProducerIceCreams.class, id);
    }
}
