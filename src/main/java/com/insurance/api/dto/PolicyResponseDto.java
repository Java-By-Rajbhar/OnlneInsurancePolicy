package com.insurance.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class PolicyResponseDto {

	private int policyId;
	private String policyName;
	private String description;
	private String feature;
}
