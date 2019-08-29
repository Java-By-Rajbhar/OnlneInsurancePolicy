package com.insurance.api.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.insurance.api.dto.FeatureDto;
import com.insurance.api.dto.PolicyDetailsDto;
import com.insurance.api.entity.Feature;
import com.insurance.api.entity.Policy;
import com.insurance.api.entity.TermAndCondition;
import com.insurance.api.repository.FeatureRepository;
import com.insurance.api.repository.PolicyRepository;
import com.insurance.api.repository.TermsAndConditionRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestPolicyDetails {

	@Mock
	private FeatureRepository featureRepository;

	@Mock
	private PolicyRepository policyRepository;

	@Mock
	private TermsAndConditionRepository termsAndConditionRepository;
	
	private Policy policy = new Policy();
	
	TermAndCondition termAndCondition = new TermAndCondition();
	
	List<Feature> featuresList = new ArrayList<Feature>();
	
	@InjectMocks
	private PolicyDetailsServiceImpl policyDetailsServiceImpl;
	
	private List<FeatureDto> featuresDtoList = new ArrayList<>();
	private PolicyDetailsDto policyDetailsDto;
	
	@Before
	public void setUp() {
	
		FeatureDto featureDto = new FeatureDto();
		featureDto.setFeatureId(101);
		featureDto.setFeatureName("Single Premium Plan");
		featureDto.setFeatureDescription("Pay Once, Enjoy Forever");
		
		FeatureDto featureDto1 = new FeatureDto();
		featureDto1.setFeatureId(102);
		featureDto1.setFeatureName("Immediate Annuity Plan");
		featureDto1.setFeatureDescription("Annuity starts as early as the next month");
		
		featuresDtoList.add(featureDto);
		featuresDtoList.add(featureDto1);
		
		policyDetailsDto = new PolicyDetailsDto();
		
		policyDetailsDto.setPolicyId(1011);
		policyDetailsDto.setPolicyName("LIC Jeevan Akshay VI");
		policyDetailsDto.setPolicyDescription("LIC Jeevan Akshay VI Plan is a Single Premium Immediate Annuity Plan which can be purchased by paying a lump sum amount. It is a non unit-linked pension plan. This plan provides for annuity payment of a fixed amount extending for a life time.");
		policyDetailsDto.setEntryAge(26 + "-" + 50);
		policyDetailsDto.setLoanFacility("Available after 3 years");
		policyDetailsDto.setMaxMaturity("Minimum – N/A");
		policyDetailsDto.setMaxPurchasePrice("100000 Rs");
		policyDetailsDto.setMinPurchasePrice("1000 Rs");
		policyDetailsDto.setPolicyTerm("Yes");
		policyDetailsDto.setSumAssured("Minimum – 1,00,000");
		policyDetailsDto.setTaxBenefits("Premium paid is tax exempt under Section 80C");
		policyDetailsDto.setFeaturs(featuresDtoList);
		
		featuresList.add(new Feature(101, 1, "ABC", "asdjnajk"));
		featuresList.add(new Feature(102, 1, "AXTRF", "asdjnajk"));
		
		policy.setDescription("policy");
		policy.setPolicyId(10);
		policy.setPolicyName("LIC Jeevan Akshay VI");
		
		termAndCondition.setLoanFacility("hello");
		termAndCondition.setMaxEntryAge(23);
		
	}
	
	
	@Test
	public void testPolicyDetails() {
		
		Mockito.when(policyRepository.findByPolicyId(Mockito.anyInt())).thenReturn(policy);
		Mockito.when(featureRepository.findByPolicyId(Mockito.anyInt())).thenReturn(featuresList);
		Mockito.when(termsAndConditionRepository.findByPolicyId(Mockito.anyInt())).thenReturn(termAndCondition);
		
		PolicyDetailsDto actualPolicyDetailsDto = policyDetailsServiceImpl.policyDetails(1011);
		assertEquals("LIC Jeevan Akshay VI", actualPolicyDetailsDto.getPolicyName());
		
	}
}
