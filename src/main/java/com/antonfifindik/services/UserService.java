package com.antonfifindik.services;

import com.antonfifindik.domain.Role;
import com.antonfifindik.domain.User;
import com.antonfifindik.persistence.UserDao;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @PostConstruct //for test
    public void init() {

//        userDao.findByUsername("antonfifindik").ifPresent(user -> {
//            user.setPassword(new BCryptPasswordEncoder().encode("123456"));
//            userDao.save(user);
//        });


        if(!userDao.findByUsername("antonfifindik").isPresent()) {
            List<Role> userRoles = new ArrayList<>();
            userRoles.add(Role.USER);
            userRoles.add(Role.ADMIN);
            userDao.save(User.builder()
                    .username("antonfifindik")
                    .password(new BCryptPasswordEncoder().encode("123456"))
                    .authorities(userRoles)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true).build());
        }

        if(!userDao.findByUsername("user1").isPresent()) {
            List<Role> userRoles = new ArrayList<>();
            userRoles.add(Role.USER);
            userDao.save(User.builder()
                    .username("user1")
                    .password(new BCryptPasswordEncoder().encode("88888888"))
                    .authorities(userRoles)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true).build());
        }
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {

       return userDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user " + username + " was not found!"));
    }
}
