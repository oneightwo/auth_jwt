package com.oneightwo.auth_jwt.security;

import com.oneightwo.auth_jwt.model.User;
import com.oneightwo.auth_jwt.security.jwt.JwtUser;
import com.oneightwo.auth_jwt.security.jwt.JwtUserFactory;
import com.oneightwo.auth_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("UserName not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);

        return jwtUser;
    }
}
