package com.obss.movietracker.springwebservice.Model.Jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {

    private static final long serialVersionUID = 121212L;

    private Long id;

    private String userName;

    private String password;

    private String token;

    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails() {
    }

    public JwtUserDetails(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public JwtUserDetails(String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    public JwtUserDetails(Long id, String userName, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.authorities = authorities;
    }

    public JwtUserDetails(String userName, Long id, String token, List<? extends GrantedAuthority> grantedAuthorities) {

        this.id = id;
        this.userName = userName;
        this.token = token;
        this.authorities = grantedAuthorities;

    }

    public JwtUserDetails(Long id, String username, String password, List<SimpleGrantedAuthority> authorities) {
        this.id = id;
        this.userName = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

}
