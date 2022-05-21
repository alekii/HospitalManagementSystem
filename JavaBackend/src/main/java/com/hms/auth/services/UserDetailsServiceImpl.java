package com.hms.auth.services;

import com.hms.auth.entity.Role;
import com.hms.auth.entity.UserData;
import com.hms.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        UserData userdata = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username could not be found"));
        //Now build userDetails, Add Granted authority
        return new User(userdata.getUsername(), userdata.getPassword(),
                setAuthority(userdata.getRole()));
    }

    private Collection<? extends GrantedAuthority> setAuthority(Set<Role> role) {
        return role.stream()
                .map(r -> new SimpleGrantedAuthority(r.getRolename().name()))
                .collect(Collectors.toList());
    }

    public int getUserId(String username) {
            Optional<UserData> userdata = userRepository.findByUsername(username);
            if (userdata.isPresent()) {
                return userdata.get().getId();
            }
        return 0;
    }

    public boolean usernameExists(String username){
        return userRepository.existsByUsername(username);
    }
}
