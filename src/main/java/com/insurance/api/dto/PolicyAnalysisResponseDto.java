package com.insurance.api.dto;

import java.util.List;

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
public class PolicyAnalysisResponseDto {

	private List<Integer> policyCount;
	private List<String> policyName;
}
