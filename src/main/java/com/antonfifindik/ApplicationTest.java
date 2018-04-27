package com.antonfifindik;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ApplicationTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        System.out.println(new BCryptPasswordEncoder().matches("123456", "$2a$10$sUzzf9izz3R.E1syjXZQk.vhfpor7yaSCiARPDAc4EJh0HHqtKdCa"));
        System.out.println(new BCryptPasswordEncoder().matches("1234567", "$2a$10$sUzzf9izz3R.E1syjXZQk.vhfpor7yaSCiARPDAc4EJh0HHqtKdCa"));
    }
}
