package com.hms.auth.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET_KEY;
    @Value("${jwt.expirationDateInMs}")
    private int EXPIRATION_TIME_MS;

    public String generateUsernameFromToken(String jwtToken){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwtToken).getBody();
        return claims.getSubject();
    }

    public Boolean verifyJWT(String jwtToken){
        try{
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(jwtToken).getBody().getSubject();
            return true;
        } catch(SignatureException | ExpiredJwtException |MalformedJwtException|UnsupportedJwtException|IllegalArgumentException e){
            e.printStackTrace();
        }
        return false;
    }

    public String generateJwt(Authentication authentication) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        User user = (User) authentication.getPrincipal();
        String authorities = user.getAuthorities()
                .stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.joining(","));
        long dateNow = new Date().getTime();
        long expirationDateInms = dateNow+EXPIRATION_TIME_MS;

        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role",authorities)
                .setIssuedAt(new Date())
                .setExpiration(new Date(expirationDateInms))
                .signWith(signatureAlgorithm,SECRET_KEY);
        return jwtBuilder.compact();
    }
}
