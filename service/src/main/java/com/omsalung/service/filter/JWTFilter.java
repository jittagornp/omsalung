/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsalung.service.filter;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author anonymous
 */
@WebFilter(filterName = "jwt-filter", urlPatterns = {"/*"})
public class JWTFilter implements Filter {

    private JWTVerifier jwtVerifier;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        jwtVerifier = new JWTVerifier(
                new Base64(true).decodeBase64("YOUR_CLIENT_SECRET"),
                "YOUR_CLIENT_ID");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = getToken((HttpServletRequest) request);

        try {
            Map<String, Object> decoded = jwtVerifier.verify(token);
            for(Map.Entry<String, Object> entry : decoded.entrySet()){
                System.out.println("key : value --> { " + entry.getKey() + " : " + entry.getValue() + " }");
            }
            
            
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw new ServletException("Unauthorized: Token validation failed", e);
        }
    }

    private String getToken(HttpServletRequest httpRequest) throws ServletException {
        String token = null;
        final String authorizationHeader = httpRequest.getHeader("authorization");
        if (authorizationHeader == null) {
            throw new ServletException("Unauthorized: No Authorization header was found");
        }

        String[] parts = authorizationHeader.split(" ");
        if (parts.length != 2) {
            throw new ServletException("Unauthorized: Format is Authorization: Bearer [token]");
        }

        String scheme = parts[0];
        String credentials = parts[1];

        Pattern pattern = Pattern.compile("^Bearer$", Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(scheme).matches()) {
            token = credentials;
        }
        return token;
    }

    @Override
    public void destroy() {

    }

}
