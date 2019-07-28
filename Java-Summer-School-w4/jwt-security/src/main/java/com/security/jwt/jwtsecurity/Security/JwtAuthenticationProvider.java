package com.security.jwt.jwtsecurity.Security;

import com.security.jwt.jwtsecurity.Model.Jwt.JwtAuthenticationToken;
import com.security.jwt.jwtsecurity.Model.Jwt.JwtUser;
import com.security.jwt.jwtsecurity.Model.Jwt.JwtUserDetails;
import com.security.jwt.jwtsecurity.Service.JwtTokenUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtTokenUtilService jwtTokenUtilService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;

        String token = jwtAuthenticationToken.getToken();

        JwtUser jwtUser = jwtTokenUtilService.getJwtUserWithToken(token);

        if (jwtUser == null) {
            throw new RuntimeException("JWT TOKEN is incorrect");
        }

        // BURASI DEĞİŞTİRİLDİ
        List<SimpleGrantedAuthority> grantedAuthorities = jwtUser.getAuthorities();

        return new JwtUserDetails(jwtUser.getUsername(), jwtUser.getId(), token, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
