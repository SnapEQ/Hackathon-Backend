package com.team1.hackathonbackend.domain.security;

import com.team1.hackathonbackend.domain.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

// NOTE: we implement the Spring Security interface via FQN to avoid name clash
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final User user;

    public UserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // expects roles like "ADMIN", "USER"
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // keep it simple for now
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // keep it simple for now
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // keep it simple for now
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Helper if you want to get the DB id from SecurityContext
    public Long getId() {
        return user.getId();
    }
}