package com.insurance.api.service;

import com.insurance.api.dto.BuyPolicyRequestDto;
import com.insurance.api.dto.BuyPolicyResponseDto;

public interface BuyService {
	
	public BuyPolicyResponseDto buyPolicy(BuyPolicyRequestDto BuyPolicyRequestDto);

}
