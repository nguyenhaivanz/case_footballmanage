package com.example.demo.Model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Bonus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double bonusmoney;
    private Date date;


}
