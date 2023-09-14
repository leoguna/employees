package com.javatpoint.uti;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	public String generateToken(String subject, String key) {
		return Jwts.builder().setId("signin").setSubject(subject).setIssuer("leo")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(100)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes())).compact();
	}

	public Claims getClaims(String key, String token) {
		return Jwts.parser().setSigningKey(Base64.getEncoder().encode(key.getBytes())).parseClaimsJws(token).getBody();
	}

}
