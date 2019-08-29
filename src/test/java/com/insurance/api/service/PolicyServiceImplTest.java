package com.insurance.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.api.dto.PolicyResponseDto;
import com.insurance.api.entity.Policy;
import com.insurance.api.entity.TermAndCondition;
import com.insurance.api.repository.PolicyRepository;
import com.insurance.api.repository.TermsAndConditionRepository;


@RunWith(SpringJUnit4ClassRunner.class)
public class PolicyServiceImplTest {

	@Mock
	private TermsAndConditionRepository termsAndConditionRepository;
	
	@Mock
	private PolicyRepository policyRepository;
	
	@InjectMocks
	private PolicyServiceImpl policyServiceImpl;
	
	
	
	@Test
	public void testPolicyList() {

		List<Policy> listPolicy=new ArrayList<>();
		Policy policy=new Policy();
		policy.setDescription("desc1");
		policy.setPolicyName("name1");
		policy.setPolicyId(1);
		listPolicy.add(policy);
		
		TermAndCondition termAndCondition=new TermAndCondition();
		termAndCondition.setLoanFacility("NA");
		termAndCondition.setMaxEntryAge(75);
		termAndCondition.setMaxMaturity("35 Years");
		termAndCondition.setMaxPurchasePrice("10000 Rs");
		termAndCondition.setMinEntryAge(18);
		termAndCondition.setMinPurchasePrice("1000 Rs");
		termAndCondition.setPolicyId(1);
		termAndCondition.setPolicyTerm("3 years");
		termAndCondition.setSumAssured("2000 Rs");
		termAndCondition.setTaxBenifits("Yes");
		termAndCondition.setTermConditionId(1);
		List<TermAndCondition> termList=new ArrayList<>();
		termList.add(termAndCondition);
		
		PolicyResponseDto policyResponseDto=new PolicyResponseDto();
		policyResponseDto.setEntryAge("18-65");
		policyResponseDto.setMaxMaturity("100000 Rs");
		policyResponseDto.setPolicyId(1);
		policyResponseDto.setPolicyName("policy1");
		policyResponseDto.setPolicyTerm("Yes");
		
	when(policyRepository.findAll()).thenReturn(listPolicy);
	when(termsAndConditionRepository.findByPolicyId(Mockito.anyInt())).thenReturn(termAndCondition);
	when(termsAndConditionRepository.findByMinEntryAgeLessThanEqual(Mockito.anyInt())).thenReturn(termList);
	when(termsAndConditionRepository.findByPolicyId(Mockito.anyInt())).thenReturn(termAndCondition);
	
	List<PolicyResponseDto> listActual=policyServiceImpl.policyList(1);
	assertEquals(1, listActual.size());
	
	}


}
