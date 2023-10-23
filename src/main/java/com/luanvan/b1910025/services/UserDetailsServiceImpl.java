package com.luanvan.b1910025.services;

import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.luanvan.b1910025.models.User;
import com.luanvan.b1910025.payloads.responses.ResourceNotFoundException;
import com.luanvan.b1910025.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl(user);
    }

    private UserDetails UserDetailsImpl(User user) {
        Collection<? extends GrantedAuthority> authorities;
        // TODO Auto-generated method stub
        return (UserDetails) new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().toString());
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id));


        return UserDetailsImpl.create(user);
    }
    // This method is used by JWTAuthenticationFilter

}
