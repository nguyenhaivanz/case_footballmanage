package com.example.demo.repository;

import com.example.demo.Model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepo extends CrudRepository<Account, Long> {
        Account findByUsername(String username);

        Account finByname(String username);
}
