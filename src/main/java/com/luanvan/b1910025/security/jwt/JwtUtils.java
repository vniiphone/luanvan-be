package com.luanvan.b1910025.security.jwt;

import com.luanvan.b1910025.repository.UserRepo;
import com.luanvan.b1910025.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Log4j2
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

//    @Value("${bezkoder.app.jwtSecret}")
//    private String jwtSecret;
//
//    @Value("${bezkoder.app.jwtExpirationMs}")
//    private int jwtExpirationMs;

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;
    @Autowired
    private UserRepo userRepo;

    public String generateToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }


//    public String generateJwtToken(Authentication authentication) {
//
//        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
//
//        return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
//                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//    }

    public Long getUserIdFromJWT(String token) {
        if (token == null || token.isBlank()) {
            log.info("No token");
            Long notId = 0L;
            return notId;
        } else {
            try {
                log.info("Have token: " + token);
                Claims claims = Jwts.parser()
                        .setSigningKey(jwtSecret)
                        .parseClaimsJws(token)
                        .getBody();

                Long id = Long.parseLong(claims.getSubject());
                log.info("Claim: " + Long.parseLong(claims.getSubject()));
                return id;
            } catch (ExpiredJwtException e) {
                // Xử lý ngoại lệ khi token đã hết hạn
                log.error("Token has expired = -1L: " + token);
                return -1L; // Hoặc một giá trị khác để biểu thị token đã hết hạn
            } catch (MalformedJwtException | SignatureException e) {
                // Xử lý ngoại lệ khi token không hợp lệ hoặc có lỗi chữ ký
                log.error("Invalid token =-2L: " + token);
                return -2L; // Hoặc một giá trị khác để biểu thị token không hợp lệ
            } catch (Exception e) {
                // Xử lý các ngoại lệ khác (nếu có)
                log.error("Failed to parse claims = -3L: " + token, e);
                return -3L; // Hoặc một giá trị khác tùy thuộc vào loại ngoại lệ
            }
        }
    }


    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String getTokenFromHttpRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

}
