package com.jp.jwt;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET_KEY = "5141B95AA14207F932B2C484A8BC3C991F040F2C3184C58A2AEE66398C55E8049CF1DEBAB0FEA3460B36FEA924326066BFA594EF011B291FAD358F62BD18BC97";
	private static final long VALIDITY = TimeUnit.MINUTES.toMillis(30);

	public String generateJwtToken(UserDetails userDetails) {
		System.out.println("Username:"+userDetails.getUsername());
		return Jwts.builder().subject(userDetails.getUsername())
					.issuedAt(Date.from(Instant.now()))
					.expiration(Date.from(Instant.now().plusMillis(VALIDITY)))
					.signWith(getSecretKey())
					.compact();

	}

	public SecretKey getSecretKey() {
		byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY.getBytes());
		return Keys.hmacShaKeyFor(decodedKey);
	}

}
