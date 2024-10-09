package com.security.securedApp.controllers;

import com.security.securedApp.dto.AuthenticationRequest;
import com.security.securedApp.dto.UserEntireRecord;
import com.security.securedApp.entity.User;
import com.security.securedApp.jwt.JwtUtil;
import com.security.securedApp.repositories.UserRepository;
import com.security.securedApp.roles.Roles;
import com.security.securedApp.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/secured")
    public String getSecuredMessage(){
        return "Hello.";
    }

    //    TODO: Register a new User
    @PostMapping("/authenticate/user/registration")
    public UserEntireRecord saveUser(@RequestBody User user){
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         user.setRole(Roles.ROLE_USER);
         User insertedUser = userRepository.save(user);
         return new UserEntireRecord(insertedUser.getUserId(),insertedUser.getUsername(),insertedUser.getPassword(),insertedUser.getRole(),insertedUser.getName(),insertedUser.getImgUrl(),insertedUser.getBio());
    }

    //    TODO: Login and return JWT
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        User user = userRepository.findByUsername(authenticationRequest.getUsername());
        record UserJWT(Long userId, String username, String password, String role, String jwt) { }
        return ResponseEntity.ok(new UserJWT(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(), jwt));

    }

}