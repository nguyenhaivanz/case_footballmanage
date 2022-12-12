package com.example.demo.Model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String PassWord;
    private String email;
    private String phonenumber;
    private String age;
    private String address;
    private String fullname;
    private String img;
    private String status;
    private double height;
    private double weight;
    private int playtime;
    private String fixedsalary;

    @OneToMany
    private List<Bonus> bonus;

    @OneToMany
    private List<Manners> manners;

    @OneToMany
    private List<Ranks> ranks;

    @OneToMany
    private List<position> positions;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rolers> roles;

    public Account() {
    }
//
//    public Account(String username, String password, List<Rolers> roles) {
//        this.username = username;
//        this.password = password;
//        this.roles = roles;
//    }
}
