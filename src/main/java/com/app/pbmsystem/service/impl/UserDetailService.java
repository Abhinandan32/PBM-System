package com.app.pbmsystem.service.impl;

import com.app.pbmsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by dawidbranicki on 20.05.2018.
 */
@Service
public class UserDetailService implements UserDetailsService {
    private UserServiceImpl userServiceImplImpl;

    @Autowired
    public UserDetailService(UserServiceImpl userServiceImplImpl) {
        this.userServiceImplImpl = userServiceImplImpl;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userServiceImplImpl.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
