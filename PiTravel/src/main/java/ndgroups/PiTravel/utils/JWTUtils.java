//package ndgroups.PiTravel.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.Date;
//import java.util.function.Function;
//
//@Service
//public class JWTUtils {
//    private static final long EXPIRATION_TIME = 1000 * 64 * 24 * 7; // for 7 days
//    private final SecretKey key;
//
//    public JWTUtils(){
//        String secretString  = "jewfuiWDFGYAYsbn75n4bvscvvabvsbvc";
////        byte[] keyBytes = Base64.getDecoder().decode(secretString.getBytes(StandardCharsets.UTF_8));
//        byte[] keyBytes = secretString.getBytes(StandardCharsets.UTF_8);
//        this.key = new SecretKeySpec(keyBytes, "HmacSHA256");
//
//    }
//
//    public String generateToken(UserDetails userDetails){
//        return Jwts.builder()
////                .setClaims(claims)
//                .subject(userDetails.getUsername())
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 10-hour expiration
//                .signWith(key)
//                .compact();
//
//    }
//    // Extract username from the token
//    public String extractUsername(String token){
//        return extractClaim(token, Claims::getSubject);
//    }
//
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
//
//}
