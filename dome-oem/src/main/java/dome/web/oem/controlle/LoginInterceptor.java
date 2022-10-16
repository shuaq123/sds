package dome.web.oem.controlle;

import com.alibaba.fastjson.JSONObject;
import com.example.base.LoginCheck;
import dome.web.oem.model.base.ResultSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
@Component
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入到拦截器中:preHandle() 方法");
        String info = new LoginCheck().tokenCheck(request);
        if (info.equals("token已过期") || info.equals("用户不存在") ) {
            JSONObject res = new JSONObject();
            res.put("success", false);
            res.put("message", "token out");
            PrintWriter out = response.getWriter();
            out.append(res.toString());
            return false;
        }
        return true;
    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("进入到拦截器中:postHandle() 方法中");
//        System.out.println(request.getRequestURI());
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("进入到拦截器中:afterCompletion() 方法中");
//        System.out.println(request.getServletPath());
//    }
}

