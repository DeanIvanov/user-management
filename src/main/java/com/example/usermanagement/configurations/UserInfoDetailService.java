package com.example.usermanagement.configurations;

import com.example.usermanagement.models.Authorities;
import com.example.usermanagement.models.User;
import com.example.usermanagement.models.dto.UserDetailsDto;
import com.example.usermanagement.repositories.AuthoritiesRepository;
import com.example.usermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getByUsername(username);
        Authorities authorities = authoritiesRepository.getByUsername(username);
        UserDetailsDto userDetailsDto = new UserDetailsDto(user.getId(), user.getUsername(),user.getPassword(), authorities.getAuthority());
        UserInfoDetails userInfoDetails = new UserInfoDetails(userDetailsDto);

        return userInfoDetails;
    }
}