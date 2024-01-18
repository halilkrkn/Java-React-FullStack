package org.halilkrkn.jwtauthenticationandauthorization.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

// JWT Service ile aslında JWT ile ilgili işlemleri yapacağız.
// Yani vereceğimiz getSigningKey() ile JWT'nin hangi anahtar ile imzalandığını belirteceğiz.
// extractAllClaims() ile JWT'nin içindeki bilgileri alacağız.
// extractUserEmail() ile JWT'nin içindeki email bilgisini alacağız.
// Burada Bir JWT'i yapısı oluşturduk.
// JWT de olması gereken tüm yapıları oluşturduk.
// JWT'nin içindeki bilgileri almak için extractAllClaims() metodunu yazdık
@Service
public class JwtService {

    private static final String SECRET_KEY = "A9pPomvZ5vkCC8OWRCkqrBn4k8EftWAxRG2enCUi0Xfzze7xEwrqmayQUF2btuo3mhOlMJR+Bo4OqMoZUOPuYg==";

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }

    // Başka bir yöntem
//    public  <T> T extractClaim(String token, String claimName, Class<T> requiredType) {
//        return extractAllClaims(token).get(claimName, requiredType);
//    }
    public <T> T extractClaim(
                    String token,
                    Function<Claims,
                    T> claimsResolver) {

        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(
            Map<String,Object> extraClaims,
            UserDetails userDetails) {
        return  Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * 1000 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
       return generateToken(Map.of(), userDetails);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


}
