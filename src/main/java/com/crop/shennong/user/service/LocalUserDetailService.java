package com.crop.shennong.user.service;

import com.crop.shennong.entity.User;
import com.crop.shennong.user.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
public class LocalUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public LocalUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(email);

        return createLocalUser(user);
    }

    @Transactional
    public LocalUser findUserById(Long id) {
        User user = userService.findUserById(id);

        return createLocalUser(user);
    }

    private LocalUser createLocalUser(User user) {
        return new LocalUser(user);
    }
}
