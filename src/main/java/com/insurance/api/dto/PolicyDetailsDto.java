package com.insurance.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDetailsDto {

	private Integer policyId;
	private String policyName;
	private String policyDescription;
	
	private String sumAssured;
	private String entryAge;
	private String minPurchasePrice;
	private String maxPurchasePrice;
	private String taxBenefits;
	private String loanFacility;
	private String policyTerm;
	private String maxMaturity;
	
	private List<FeatureDto> featurs;
	
}
