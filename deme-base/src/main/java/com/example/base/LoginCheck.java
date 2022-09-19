package com.example.base;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;


public class LoginCheck {

    public String tokenCheck(HttpServletRequest request){
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)) return "用户不存在";
        Claims jwt = new JwtUtils().parseJwt(token);
        if (jwt == null){
            return "token已过期";
        }
        else {
            return "通过";
        }


    }

}
