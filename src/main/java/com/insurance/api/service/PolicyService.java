package com.insurance.api.service;

import java.util.List;

import com.insurance.api.dto.PolicyResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface PolicyService {

	public List<PolicyResponseDto> policyList(int age);
	
}
