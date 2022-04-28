package com.womakerscode.auth.server.service.impl;

import com.womakerscode.auth.server.model.UserDetail;
import com.womakerscode.auth.server.model.entity.User;
import com.womakerscode.auth.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userDetailRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("Username or password was wrong"));

        UserDetails userDetails = new UserDetail(user);
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;

    }
}
