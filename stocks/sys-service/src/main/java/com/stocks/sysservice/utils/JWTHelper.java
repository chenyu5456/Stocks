package com.stocks.sysservice.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.time.DateUtils;
import org.checkerframework.checker.units.qual.A;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ChenYu
 * @Date: 2019/2/20 10:47
 * @Description: Jwt的工具处理类
 */
public class JWTHelper {

    /**
     * 使用jwt生成token
     * @param claims
     * @param secret
     * @param issuer 发行者
     * @return
     */
    public static String getToken(Map<String, String> claims, String secret, String issuer){
        //根据Hmac256获取一个加密对象
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTCreator.Builder builder = JWT.create().withIssuer(issuer).withExpiresAt(DateUtils.addDays(new Date(), 1));
            claims.forEach((k, v)  -> builder.withClaim(k, v));
            return builder.sign(algorithm).toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 验证token的方法
     * @param token
     * @param secret
     * @param issuer
     * @return
     */
    public static Map<String, String> verifyToken(String token, String secret, String issuer){
        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256(secret);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> map = jwt.getClaims();
        HashMap<String, String> resultMap = Maps.newHashMap();
        map.forEach((k, v) -> resultMap.put(k, v.asString()));
        return resultMap;
    }

/*    public static void main(String[] args) {
        String secret = "545641154yu";
        String issuer = "chenyu";
        Map<String, String> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "admin123");
        String token = getToken(map, secret, issuer);
        System.out.println(token);

        Map<String, String> map1 = verifyToken(token, secret, issuer);
        System.out.println(map1.get("password"));
    }*/
}
