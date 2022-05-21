package com.hms.auth.jwt;

import com.hms.auth.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
           try{
               //get jwt token from request header
               String authToken = request.getHeader("Authorization");
              if(authToken!=null ) {

                  //My impl - first verify jwt
                  Boolean jwtIsVerified = jwtUtil.verifyJWT(authToken);
                  if (jwtIsVerified) {
                      //get user identity
                      UserDetails userDetails = userDetailsService.loadUserByUsername(jwtUtil.generateUsernameFromToken((authToken)));
                      //set user identity in security context
                      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                      authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                      SecurityContextHolder.getContext().setAuthentication(authentication);
                  }

              }
           }catch(Exception e){
               e.getStackTrace();
           }
           filterChain.doFilter(request,response);
    }
}
