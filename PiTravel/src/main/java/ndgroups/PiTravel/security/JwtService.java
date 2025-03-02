package ndgroups.PiTravel.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import ndgroups.PiTravel.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Service
public class JwtService {
    private static final long expirationTime = 1000 * 64 * 24 * 7; // for 7 days
    @Value("${auth.token.jwtSecret}")
    private String jwtSecret;
//    @Value(("${auth.token.expirationTime}"))
//    private  int expirationTime;

    public String generateToken(Authentication authentication){
        CustomUserDetails userPrinciple = (CustomUserDetails) authentication.getPrincipal();
        List<String> roles = userPrinciple.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        return Jwts.builder()
//                .setClaims(claims)
                .setSubject(userPrinciple.getEmail())
                .claim("id", userPrinciple.getId())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expirationTime))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private SecretKey key() {
        byte[] decodedKey = Base64.getDecoder().decode(jwtSecret);
        return Keys.hmacShaKeyFor(decodedKey);
    }



//    public JwtService(){
//        String secretString  = "jewfuiWDFGYAYsbn75n4bvscvvabvsbvc";
////        byte[] keyBytes = Base64.getDecoder().decode(secretString.getBytes(StandardCharsets.UTF_8));
//        byte[] keyBytes = secretString.getBytes(StandardCharsets.UTF_8);
//        this.key = new SecretKeySpec(keyBytes, "HmacSHA256");
//
//    }
//

//    // Extract username from the token
    public String extractUsername(String token){
//        return extractClaim(token, Claims::getSubject);
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody().getSubject();

    }

//    // Extract any claim from the token
//    public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction) {
//        return claimsTFunction.apply(Jwts.parser().verifyWith(key).build().parseSignedClaims(token)
//                .getPayload());
//    }
//
//    // Validate token by comparing it with the username
//    public Boolean isValidToken(String token, UserDetails userDetails) {
//        final String extractedUsername = extractUsername(token);
//        return (extractedUsername.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    // Check if the token is expired
//    private Boolean isTokenExpired(String token) {
////        return extractExpiration(token).before(new Date());
//        return extractClaim(token, Claims::getExpiration).before(new Date());
//    }

}