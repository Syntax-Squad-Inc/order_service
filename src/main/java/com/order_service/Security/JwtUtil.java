package com.order_service.Security;

public class JwtUtil 
{
    package com.order_service.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "my_secret_key"; // 🔐 Use env variables in real apps
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour (in ms)

    // ✅ Generate token for a user
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // store username
                .setIssuedAt(new Date(System.currentTimeMillis())) // issued time
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // expires in 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // signed with HS256 algo
                .compact(); // builds the token
    }

    // ✅ Extract username from token
    public String extractUsername(String token) {
        return parseToken(token).getBody().getSubject();
    }

    // ✅ Check if token is valid
    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 🔍 Internal method to parse token
    private Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
    }
}


}
