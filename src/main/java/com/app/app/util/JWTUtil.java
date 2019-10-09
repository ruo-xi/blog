package com.app.app.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;


import java.util.Date;

public class JWTUtil {

    private  static final long  EXPRIE_TIME = 24 * 60 * 60 * 1000;

    public static String sign(String userName, String userPwd){
        try {
            Date date = new Date(System.currentTimeMillis() + EXPRIE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(userPwd);

            return JWT.create()
                    .withClaim("userName", userName)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            return null;
        }
    }

    public static boolean vertify(String token, String userName, String userPwd){
        try {
            Algorithm algorithm = Algorithm.HMAC256(userPwd);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userName", userName)
                    .build();

            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static String getUserName(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        }catch (JWTDecodeException e){
            return null;
        }
    }



}
