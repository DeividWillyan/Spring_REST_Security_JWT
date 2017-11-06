package br.com.RESTful.security;

import java.io.IOException;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.RESTful.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

    private static final String secretKey = "Unifil_Mil_Grau";

    public static String generateToken(User user)
            throws JsonProcessingException {
        final Long hora = 1000L * 60L * 60L;
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        Date agora = new Date();
        return Jwts.builder().claim("usr", userJson)
                .setIssuer("br.com.RESTful")
                .setSubject(user.getUsername())
                .setExpiration(new Date(agora.getTime() + hora))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }

    public static UserDetails parseToken(String token)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String userJson = Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().get("usr", String.class);
        return mapper.readValue(userJson, User.class);
    }

}