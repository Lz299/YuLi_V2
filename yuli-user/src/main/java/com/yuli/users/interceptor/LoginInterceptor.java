package com.yuli.users.interceptor;


import com.yuli.users.utils.JwtUtil;
import com.yuli.users.utils.ThreadLocalUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor{



    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      String token=  request.getHeader("Authorization");

        try {

            //redis 获取token

            ValueOperations<String,String> vo=stringRedisTemplate.opsForValue();
          String redisToken=  vo.get("token");
            if (redisToken== null){
                throw new RuntimeException();
            }
            Map<String, Object> map = JwtUtil.parseToken(token);


            ThreadLocalUtil.set(map);




            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       ThreadLocalUtil.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
