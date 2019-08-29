package com.insurance.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuyPolicy {

    private int buyPolicyId;
    private int policyId;
    private int customerId;
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
}