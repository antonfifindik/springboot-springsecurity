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

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(@NonNull String s) throws UsernameNotFoundException {

       return userDao.findByUsername(s).orElse(null);

//        List<Role> userRoles = new ArrayList<>();
//        userRoles.add(Role.USER);
//        return User.builder()
//                .username(s)
//                .password("123456")
//                .authorities(userRoles)
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .credentialsNonExpired(true)
//                .enabled(true).build();
    }
}
