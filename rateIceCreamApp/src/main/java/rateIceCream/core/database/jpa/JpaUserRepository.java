package rateIceCream.core.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rateIceCream.core.domain.User;

import java.util.List;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {

    List<User> findByLogin(String login);

}
