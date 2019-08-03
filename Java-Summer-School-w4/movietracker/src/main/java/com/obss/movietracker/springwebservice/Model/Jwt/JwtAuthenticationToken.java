package com.obss.movietracker.springwebservice.Model.Jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

// INSTANCE OF AUTHENTICATION
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = 121212L;

    private String token;

    private String username;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public JwtAuthenticationToken(String token, Collection<? extends GrantedAuthority> authorities) {
        super(null, null, authorities);
        this.token = token;
    }

    public JwtAuthenticationToken(String token, Collection<? extends GrantedAuthority> authorities, String username) {
        super(null, null, authorities);
        this.token = token;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

}
