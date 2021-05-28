package com.austin.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.SecurityUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Description:获取用户信息的工具类
 * @Author:GongJun
 * @Date:2019/1/22
 */
public class JWTUtil {
    // 过期时间
    private static final long EXPIRE_TIME = 100 * 24 * 60 * 60 * 1000;

    private static final String secret = "9e7fa2f50f37a60876b5aaa0f34f418d";

    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    public static boolean verify(String token, String userId, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("user", userId + "," + username).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            String tmp = jwt.getClaim("user").asString();

            return tmp.split(",", 2)[1];
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            String tmp = jwt.getClaim("user").asString();

            return tmp.split(",", 2)[0];
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String getUserId() {
        return getUserId(SecurityUtils.getSubject().getPrincipal().toString());
    }

    public static String getUsername() {
        return getUsername(SecurityUtils.getSubject().getPrincipal().toString());
    }

    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @return 加密的token
     */
    public static String sign(String userId, String username) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create().withClaim("user", userId + "," + username).withExpiresAt(date).sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
