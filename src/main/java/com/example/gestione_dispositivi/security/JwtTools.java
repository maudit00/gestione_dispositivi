package com.example.gestione_dispositivi.security;


import com.example.gestione_dispositivi.exceptions.UnauthorizedException;
import io.jsonwebtoken.Jwts;
import com.example.gestione_dispositivi.models.Employees;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@PropertySource("application.properties")
public class JwtTools {
    @Value("${spring.jwt.secret")
    private String secret;
    @Value("${spring.jwt.expirationMs")
    private String expirationMs;

    public String createToken(Employees employees){
        return Jwts.builder().subject(employees.getUsername()).issuedAt(new Date(System.currentTimeMillis())).
                expiration(new Date(System.currentTimeMillis()+Long.parseLong(expirationMs))).
                signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
    }


    public void validateToken(String token){
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(token);
        } catch (Exception e){
           throw new UnauthorizedException(e.getMessage());
        }
    }

    public String extractIdFromToken (String token){
       return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parseSignedClaims(token).
       getPayload().getSubject();
    }
}
