package com.insurance.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrendingResponseDTO {
	private String policyName; 
	private int count;
	private int percentage;

}
