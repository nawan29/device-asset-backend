package com.example.deviceassetsystem.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    private static final String SECRET = "MySecretKeyForDeviceSystem"; // 密钥
    private static final long EXPIRATION = 86400000; // 过期时间 24小时

    // 生成 Token
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    // 校验 Token
    public static void validateToken(String token) {
        Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
    }

    // 从 Token 中获取用户名
    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}