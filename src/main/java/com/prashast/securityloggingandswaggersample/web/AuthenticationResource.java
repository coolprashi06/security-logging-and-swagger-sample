package com.prashast.securityloggingandswaggersample.web;

import com.prashast.securityloggingandswaggersample.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationResource {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/gettoken", method = RequestMethod.GET)
    public String getToken(@RequestParam String subject, @RequestParam String issuer){

        Map<String, Object> claims = new HashMap<>();
        claims.put("A", 1);
        claims.put("B", 2);

       return jwtTokenUtil.generateToken(claims, subject,issuer);
    }
}
