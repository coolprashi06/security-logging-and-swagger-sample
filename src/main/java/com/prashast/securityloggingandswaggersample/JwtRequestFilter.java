package com.prashast.securityloggingandswaggersample;

import com.prashast.securityloggingandswaggersample.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = httpServletRequest.getHeader("Authorization");

        if(StringUtils.hasLength(authorizationHeader) && authorizationHeader.startsWith("Bearer")){
            String actualJwt = authorizationHeader.substring(7);
            boolean tokenValidation = jwtTokenUtil.validateToken(actualJwt);

            if(tokenValidation){
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("MyApp", null, new ArrayList<>()));
            }
        }else {
            logger.warn("Authorization header is missing or invalid");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
