package com.makingfitnessbetter.makingfitnessbetter.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
public class TransactionLog {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transId;

}
