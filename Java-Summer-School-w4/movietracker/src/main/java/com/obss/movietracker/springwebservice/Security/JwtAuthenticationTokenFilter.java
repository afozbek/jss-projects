package com.obss.movietracker.springwebservice.Security;

import com.obss.movietracker.springwebservice.Model.Jwt.JwtAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("/admin/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            throw new RuntimeException("JWT Token is missing");
        }

        String authenticationToken = header.substring(7);

        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);

        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        super.successfulAuthentication(request, response, chain, authResult);

        System.out.println("SUCCESSFULLY AUTHENTICATED.....................");

        chain.doFilter(request, response);
    }

    // @Override
    // public void doFilter(ServletRequest req, ServletResponse res, FilterChain
    // chain) throws IOException, ServletException {
    // HttpServletRequest request = (HttpServletRequest) req;
    // HttpServletResponse response = (HttpServletResponse) res;
    //
    //
    //
    // chain.doFilter(req, res);
    // }
}
