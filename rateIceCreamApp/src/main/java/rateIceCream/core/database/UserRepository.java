package rateIceCream.core.database;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.domain.User;

import java.util.List;

@Component
@Transactional
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void register(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List<User> findByLogin(String login) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE login = :login");
        query.setParameter("login", login);
        return query.getResultList();
    }
}
