package rateIceCream.core.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import rateIceCream.core.database.jpa.JpaUserRepository;
import rateIceCream.core.domain.User;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JpaUserRepository userRepository;

    public UserDetailsServiceImpl(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new UserDetailsImpl(user);
    }

}
