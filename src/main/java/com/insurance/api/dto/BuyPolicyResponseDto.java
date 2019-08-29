package com.insurance.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BuyPolicyResponseDto {

	
	private int statusCode;
	private String message;
	private String status;
}
