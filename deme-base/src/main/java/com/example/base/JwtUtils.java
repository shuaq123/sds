package com.example.base;

import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


import java.util.Date;
import java.util.Map;

/**
  2  * @author: Mr.Yang
  3  * @create: 2020-02-13 21:19
  4  **/
  @Getter
  @Setter
  @ConfigurationProperties("jwt.config")
  public class JwtUtils {
     //签名私
        // private String key;
     //签名失效时间
     private Long failureTime;

    /**
 15      * 设置认证token
 16      *
 17      * @param id      用户登录ID
 18      * @param subject 用户登录名
 19      * @param map     其他私有数据
 20      * @return
 21      */
    public String createJwt(String id, String subject, Map<String, Object> map) {

                     //1、设置失效时间啊
                     long now = System.currentTimeMillis();  //毫秒
                     long exp = now + 377777777;

                     //2、创建JwtBuilder
                     JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(subject)
                             .setIssuedAt(new Date())
                             //设置签名防止篡改
                            .signWith(SignatureAlgorithm.HS256, "userlogin");

                     //3、根据map设置claims
                     for (Map.Entry<String, Object> entry : map.entrySet()) {
                             jwtBuilder.claim(entry.getKey(), entry.getValue());
                         }
                     jwtBuilder.setExpiration(new Date(exp));

                     //4、创建token
                     String token = jwtBuilder.compact();
                     return token;
                 }
/**
 46      * 解析token  验证用户
 47      *
 48      * @param token
 49      * @return
 50      */
             public Claims parseJwt(String token) {
                 Claims claims = null;
                 try {
                     Claims claims1 = Jwts.parser().setSigningKey("userlogin").parseClaimsJws(token).getBody();
                     return claims1;
                 }catch (ExpiredJwtException e){

                     return claims;
                 }

               }






}