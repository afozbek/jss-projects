package com.obss.movietracker.springwebservice.Service.Jwt;

import com.obss.movietracker.springwebservice.Model.Jwt.JwtUser;
import com.obss.movietracker.springwebservice.Model.Jwt.JwtUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtTokenUtilService {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String secret;

    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    public String generateToken(JwtUserDetails jwtUserDetails) {
        String userName = jwtUserDetails.getUserName();

        Claims claims = Jwts.claims().setSubject(userName);

        claims.put("userId", jwtUserDetails.getId());
        claims.put("authorities", jwtUserDetails.getAuthorities().stream()
                .map(s -> s.toString())
                .collect(Collectors.toList()));

        return doGenerateToken(claims);
    }

    private String doGenerateToken(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public Boolean validateToken(String token, JwtUserDetails jwtUserDetails) {
        final String username = getUserNameFromToken(token);

        return (username.equals(jwtUserDetails.getUserName()) && !isTokenExpired(token));
    }

    public JwtUser getJwtUserWithToken(String token) {
        JwtUser jwtUser = null;

        try {
            Claims body = Jwts
                    .parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            @SuppressWarnings("unchecked") final List<String> authorities = (List<String>) body.get("authorities", List.class);
            final List<SimpleGrantedAuthority> auths = authorities.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            jwtUser.setId(body.get("userId", Long.class));
            jwtUser.setUsername(body.getSubject());
            jwtUser.setAuthorities(auths);

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return jwtUser;
    }
}
