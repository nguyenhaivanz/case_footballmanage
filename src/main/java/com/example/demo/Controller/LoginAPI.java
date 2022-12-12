package com.example.demo.Controller;

import com.example.demo.Model.Account;
import com.example.demo.Service.JwtService;
import com.example.demo.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    IAccountRepo iAccountRepo;

    @GetMapping("/getallaccount")
    public List<Account> getAccountEntity() {
        return (List<Account>) iAccountRepo.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account accountEntity) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(accountEntity.getUsername(), accountEntity.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtService.createToken(authentication);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
