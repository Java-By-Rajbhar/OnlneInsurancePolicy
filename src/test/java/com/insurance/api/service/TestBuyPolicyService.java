package com.insurance.api.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.insurance.api.dto.BuyPolicyRequestDto;
import com.insurance.api.dto.BuyPolicyResponseDto;
import com.insurance.api.entity.BuyPolicy;
import com.insurance.api.entity.PolicyHolder;
import com.insurance.api.repository.BuyPolicyRepository;
import com.insurance.api.repository.PolicyHolderRepository;
import com.insurance.api.repository.PolicyRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestBuyPolicyService {

	@Mock
	private BuyPolicyRepository buyPolicyRepository;
	
	@Mock
	private PolicyRepository policyRepository;
	
	@Mock
	private PolicyHolderRepository policyHolderRepository;
	
	@InjectMocks
	private BuyServiceImpl buyServiceImpl;
	
	BuyPolicyRequestDto buyPolicyRequestDto =new BuyPolicyRequestDto();
	BuyPolicyResponseDto buyPolicyResponseDto = new BuyPolicyResponseDto();
	PolicyHolder policyHolder = new PolicyHolder();
	BuyPolicy buyPolicy = new BuyPolicy();
	
	@Before
	public void setUp() {
		buyPolicyResponseDto.setStatus("Success");
		policyHolder.setCustomerId(101);
		buyPolicy.setBuyPolicyId(1010);
		buyPolicyRequestDto.setEmail("laxman@hcl.com");
	}
	
	@Test
	public void testBuyPolicy(){
	
		Mockito.when(policyHolderRepository.save(Mockito.anyObject())).thenReturn(policyHolder);
		Mockito.when(buyPolicyRepository.save(Mockito.anyObject())).thenReturn(buyPolicy);
		
		BuyPolicyResponseDto actualBuyPolicyResponseDto = buyServiceImpl.buyPolicy(buyPolicyRequestDto);
		assertEquals("Success", actualBuyPolicyResponseDto.getStatus());
	}
	
}
