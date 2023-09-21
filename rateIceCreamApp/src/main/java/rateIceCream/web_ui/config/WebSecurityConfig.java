package rateIceCream.web_ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("password"))
                        .roles("USER")
                        .build();

        UserDetails admin =
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("password"))
                        .roles("ADMIN")
                        .build();
        return new InMemoryUserDetailsManager(user, admin);
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity
                .authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/addIceCream").hasAnyRole("ADMIN", "STAFF")
                .antMatchers("/addIceCreamRating").hasAnyRole("USER", "STAFF", "ADMIN")
                .antMatchers("/addProducer").hasRole("ADMIN")
                .antMatchers("/getAllIceCreams").hasAnyRole("USER", "STAFF", "ADMIN")
                .antMatchers("/getAverageIceCreamRating").hasAnyRole("USER", "STAFF", "ADMIN")
                .antMatchers("/registerUser").hasRole("ADMIN")
                .antMatchers("/removeIceCream").hasRole("ADMIN")
                .antMatchers("/searchIceCream").hasAnyRole("USER", "STAFF", "ADMIN")
                .anyRequest().authenticated();
        return httpSecurity.build();
    }


}