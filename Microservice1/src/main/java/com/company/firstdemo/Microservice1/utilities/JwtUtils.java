package com.company.firstdemo.Microservice1.utilities;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    public String createJWT(String email, String name, Date date){

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(date)
                .claim("name",name)
                .signWith(
                        SignatureAlgorithm.HS256,
                        "MyPersonalSecretKey123456".getBytes(StandardCharsets.UTF_8)
                )
                .compact();
    }

    public Map<String, Object> jwt2Map(String jwt) throws java.io.UnsupportedEncodingException, ExpiredJwtException {

        Jws<Claims> claim = Jwts.parser()
                .setSigningKey("myPersonalSecretKey12345".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(jwt);

        String name = claim.getBody().get("name", String.class);

        Date expDate = claim.getBody().getExpiration();
        String email = claim.getBody().getSubject();

        Map<String, Object> userData = new HashMap<>();
        userData.put("email", email);
        userData.put("name", name);
        userData.put("exp_date", expDate);

        Date now = new Date();
        if (now.after(expDate)) {
            throw new ExpiredJwtException(null, null, "Session expired!");
        }

        return userData;
    }

    /**
     * this method extracts the jwt from the header or the cookie in the Http request
     *
     * @param request the request of te endpoint
     * @return jwt
     */
    public String getJwtFromHttpRequest(HttpServletRequest request) {
        String jwt = null;
        if (request.getHeader("jwt") != null) {
            jwt = request.getHeader("jwt");     //token present in header
        } else if (request.getCookies() != null) {
            Cookie[] cookies = request.getCookies();   //token present in cookie
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwt")) {
                    jwt = cookie.getValue();
                }
            }
        }
        return jwt;
    }




}
