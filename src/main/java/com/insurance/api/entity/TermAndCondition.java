package com.insurance.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class TermAndCondition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int termConditionId; 
	private int policyId; 
	private String sumAssured; 
	private int maxEntryAge; 
	private int minEntryAge; 
	private String minPurchasePrice ;
	private String maxPurchasePrice; 
	private String modeOfAnuityPayment; 
	private String taxBenifits; 
	private String loanFacility; 
	private String policyTerm ;
	private String modesOfPremimumPayment; 
	private String policyRevival; 
	private String gracePeriod; 
	private String maxMaturity; 
	private String ageofPolicyMaturity; 



}
