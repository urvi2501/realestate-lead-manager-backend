package RealEstateLeadManager;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

   @Value("${jwt.secret}")
private String secretKey;

private static final long EXPIRATION_TIME =
        1000 * 60 * 60; // 1 hour
private SecretKey getKey() {
    return Keys.hmacShaKeyFor(secretKey.getBytes());
}

    public String generateToken(String email, String role) {

        return Jwts.builder()
                .subject(email)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis()
                                + EXPIRATION_TIME)
                )
                .signWith(getKey())
                .compact();
    }

    public String extractEmail(String token) {

        return getClaims(token)
                .getSubject();
    }

public String extractRole(String token) {
    return getClaims(token)
            .get("role", String.class);
}

public boolean isTokenValid(String token) {

    try {

        getClaims(token);

        System.out.println("JWT VALID");

        return true;

    } catch (Exception e) {

        System.out.println("JWT INVALID");
        System.out.println("JWT ERROR: " + e.getMessage());

        return false;
    }
}
    private Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}