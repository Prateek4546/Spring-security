package com.Security.SecurityLearning.config.security.filters;

import com.Security.SecurityLearning.config.security.authentication.CustomAuthentication;
import com.Security.SecurityLearning.config.security.managers.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private  final CustomAuthenticationManager customAuthenticationManger;

    @Autowired
    public CustomAuthenticationFilter(CustomAuthenticationManager customAuthenticationManger) {
        this.customAuthenticationManger = customAuthenticationManger;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

          // 1. create an authentication  object   which is not  yet authenticated
         // 2. delegate  the authentication object  to manager
        //  3. get back the authentication from manager
       //   4. if the object is authenticated then send  to the next filter in the chain

        String key = String.valueOf(request.getHeader("key"));
        CustomAuthentication customAuthentication = new CustomAuthentication(false, key);

        var u = customAuthenticationManger.authenticate(customAuthentication);
        if(u.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(u);
            filterChain.doFilter(request , response); // only when authentication worked
        }


    }
}
