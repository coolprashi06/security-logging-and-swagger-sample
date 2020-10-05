package com.prashast.securityloggingandswaggersample.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final long TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwk}")
    private String jwk;

    public String generateToken(Map<String, Object> claims, String subject, String issuer){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuer(issuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512, jwk)
                .compact();
    }

    public boolean validateToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwk)
                .parseClaimsJws(token)
                .getBody();

        return !claims.getExpiration().before(new Date());
    }

}
