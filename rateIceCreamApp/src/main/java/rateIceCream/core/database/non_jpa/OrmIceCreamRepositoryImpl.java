package rateIceCream.core.database.non_jpa;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import rateIceCream.core.database.non_jpa.IceCreamRepository;
import rateIceCream.core.domain.IceCream;

import java.util.List;
import java.util.Optional;

//@Component
//@Transactional
public class OrmIceCreamRepositoryImpl implements IceCreamRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(IceCream iceCream) {
        sessionFactory.getCurrentSession().save(iceCream);
    }

    @Override
    public boolean deleteById(Long id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE IceCream WHERE id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public List<IceCream> getAllIceCreams() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM IceCream i", IceCream.class)
                .getResultList();
    }

    @Override
    public List<IceCream> findByName(String name) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM IceCream i WHERE name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<IceCream> findByProducer(String producer) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM IceCream i WHERE producer = :producer");
        query.setParameter("producer", producer);
        return query.getResultList();
    }

    @Override
    public List<IceCream> findByNameAndProducer(String name, String producer) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM IceCream i WHERE name = :name AND producer = :producer");
        query.setParameter("name", name);
        query.setParameter("producer", producer);
        return query.getResultList();
    }

    @Override
    public List<IceCream> findByBarcode(String barcode) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM IceCream i WHERE barcode = :barcode");
        query.setParameter("barcode", barcode);
        return query.getResultList();
    }

    @Override
    public Optional<IceCream> findById(Long id) {
        IceCream iceCream = sessionFactory.getCurrentSession().get(IceCream.class, id);
        if (iceCream == null) {
            return Optional.empty();
        } else {
            return Optional.of(iceCream);
        }
    }
}
