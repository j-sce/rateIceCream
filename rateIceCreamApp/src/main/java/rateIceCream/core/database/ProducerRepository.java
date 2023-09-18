package rateIceCream.core.database;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.domain.Producer;

import java.util.List;


//@Component
//@Transactional
public class ProducerRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public void save(Producer producer) {
        sessionFactory.getCurrentSession().save(producer);
    }

    public Producer findById(Long id) {
        return sessionFactory.getCurrentSession().get(Producer.class, id);
    }

    public List<Producer> findByName(String name) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT p FROM Producer p WHERE name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }
}
