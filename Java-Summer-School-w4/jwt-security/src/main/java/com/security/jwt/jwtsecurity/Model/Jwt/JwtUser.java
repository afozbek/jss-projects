package com.security.jwt.jwtsecurity.Model.Jwt;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class JwtUser {

    private Long id;

    private String username;

    private String password;

    private List<SimpleGrantedAuthority> authorities;

    public List<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
