package com.antonfifindik.services;

import com.antonfifindik.domain.Role;
import com.antonfifindik.domain.User;
import com.antonfifindik.persistence.UserDao;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        if(!userDao.findByUsername("antonfifindik").isPresent()) {
            List<Role> userRoles = new ArrayList<>();
            userRoles.add(Role.USER);
            userRoles.add(Role.ADMIN);
            userDao.save(User.builder()
                    .username("antonfifindik")
                    .password("123456")
                    .authorities(userRoles)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true).build());
        }
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String s) throws UsernameNotFoundException {

       return userDao.findByUsername(s).orElse(null);
    }
}
