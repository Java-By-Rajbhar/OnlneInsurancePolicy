package com.insurance.api.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BuyPolicyRequestDto {
	
	private int policyId;
	private String name;
	private String email;
	private int age;
	private String gender;
	private int empId;
	private String relationship;

}
