package com.example.demo.Controller;

import com.example.demo.Model.Account;
import com.example.demo.Service.AccountService;
import com.example.demo.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class registerAPI {
    @Autowired
    IAccountRepo iAccountRepo;

    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        iAccountRepo.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/checkUsername")
    public ResponseEntity<Account> checkUser(@RequestParam String username) {
        Account account = iAccountRepo.finByname(username);
        if (account == null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(account, HttpStatus.BAD_REQUEST);
        }
    }
}
//    @PostMapping
//    public ResponseEntity save(@RequestBody AccountEntity accountEntity){
//        SendEmailAPI sendEmailAPI = new SendEmailAPI();
//        Random generator = new Random();
//        generator.nextInt();
//        sendEmailAPI.sendMail( accountEntity.getUsername(), "Codegym xin thông báo", String.valueOf(generator.nextInt()) + " là mã xác thực của bạn");
////        AccountService.save(accountEntity);
//        return new ResponseEntity(HttpStatus.OK);
//    }

