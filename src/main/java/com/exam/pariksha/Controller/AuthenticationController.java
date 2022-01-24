package com.exam.pariksha.Controller;

import com.exam.pariksha.config.JwtUtil;
import com.exam.pariksha.model.JwtRequest;
import com.exam.pariksha.model.JwtResponse;
import com.exam.pariksha.model.User;
import com.exam.pariksha.services.implementation.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserDetailImpl userDetail;

    @Autowired
    private JwtUtil jwtUtil;





    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{

        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("USER NOT FOUND");
        }

        UserDetails userDetails=this.userDetail.loadUserByUsername(jwtRequest.getUsername());

        String Token = this.jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(Token));
    }

    private void authenticate(String username,String password) throws Exception{

        try{

            authManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));


        }catch (DisabledException e){
            throw new Exception("USER DISABLED");
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials");
        }

    }

    @GetMapping("/current-user")
    public User getCurrentUSer(Principal principal){

        return ((User)this.userDetail.loadUserByUsername(principal.getName()));
    }
}
