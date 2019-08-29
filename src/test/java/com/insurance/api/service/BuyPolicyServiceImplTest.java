package com.insurance.api.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.insurance.api.dto.PolicyAnalysisResponseDto;
import com.insurance.api.entity.Policy;
import com.insurance.api.repository.BuyPolicyRepository;
import com.insurance.api.repository.PolicyRepository;

@RunWith(MockitoJUnitRunner.class)
public class BuyPolicyServiceImplTest {
	
	@InjectMocks
	BuyPolicyServiceImpl buyPolicyServiceImpl;
	
	@Mock
	BuyPolicyRepository buyPolicyRepository;
	@Mock
	PolicyRepository policyRepository;
	
	@Test
	public void analysisTest()
	{
		List<Integer[]> listArray = new ArrayList<>();
		
		Integer[] intArray =new Integer[10];
		intArray[0]=10;
		intArray[1]=11;
		Integer[] intArray1 =new Integer[10];
		intArray1[0]=12;
		intArray1[1]=13;
		listArray.add(intArray);
		listArray.add(intArray1);
		
		Policy policy =  new Policy();
		policy.setPolicyId(100);
		policy.setPolicyName("insurance");
		
		Mockito.when(buyPolicyRepository.getPolicyNameAndCount()).thenReturn(listArray);
		
		Mockito.when(policyRepository.findByPolicyId(Mockito.anyInt())).thenReturn(policy);
		
		PolicyAnalysisResponseDto responseDto = buyPolicyServiceImpl.analysis();
		
		assertEquals(2, responseDto.getPolicyCount().size());
	}

}
