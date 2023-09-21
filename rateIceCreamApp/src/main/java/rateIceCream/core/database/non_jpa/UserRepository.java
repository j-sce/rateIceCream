package rateIceCream.core.database.non_jpa;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.domain.User;

import java.util.List;

//@Component
//@Transactional
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void register(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User findById(Long id){
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> findByLogin(String login) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE login = :login");
        query.setParameter("login", login);
        return query.getResultList();
    }

}
