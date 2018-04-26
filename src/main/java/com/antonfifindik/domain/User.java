package com.antonfifindik.domain;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

@Data
public class User implements UserDetails {
    private List<Role> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
