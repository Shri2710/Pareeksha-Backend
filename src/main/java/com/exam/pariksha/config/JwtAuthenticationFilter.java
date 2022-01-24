package com.exam.pariksha.config;

import com.exam.pariksha.services.implementation.UserDetailImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailImpl userDetailImpl;

    @Autowired JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {



        String requestTokenHeader=request.getHeader("Authorization");

        System.out.println(requestTokenHeader);
        String username=null;
        String jwtToken=null;

        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){


            jwtToken=requestTokenHeader.substring(7);

            try{
                username=jwtUtil.extractUsername(jwtToken);
            }catch(ExpiredJwtException e){
                System.out.println(e);
                System.out.println("Token has expired");
            }catch(Exception e){
                System.out.println("error");
            }


        }else{
            System.out.println("Header dont startwith Bearer");
        }


        if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null){

            final UserDetails userDetail=this.userDetailImpl.loadUserByUsername(username);


            if(this.jwtUtil.validateToken(jwtToken,userDetail)){

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetail,null,userDetail.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else{
            System.out.println("Token is not valid");
        }

        filterChain.doFilter(request,response);
    }
}
