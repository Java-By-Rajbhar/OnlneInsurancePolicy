package com.insurance.api.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.api.dto.SuggestionResponseDto;
import com.insurance.api.dto.TrendingResponseDTO;
import com.insurance.api.entity.Policy;
import com.insurance.api.repository.BuyPolicyRepository;
import com.insurance.api.repository.PolicyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class TrendServiceImplTest {

	@Mock
	BuyPolicyRepository buyPolicyRepository;

	@Mock
	PolicyRepository policyRepository;

	@InjectMocks
	TrendServiceImpl trendServiceImpl;

	@Test
	public void getTrendingPoliciesTest() {

		List<TrendingResponseDTO> trendingResponseList = new ArrayList<>();
		TrendingResponseDTO trendingResponseDTO = new TrendingResponseDTO();

		trendingResponseDTO.setCount(2);
		trendingResponseDTO.setPolicyName("Ajith");
		trendingResponseDTO.setTotalCount(45);
		trendingResponseList.add(trendingResponseDTO);

		Policy policy = new Policy();
		policy.setPolicyId(1);

		List<Integer[]> count = new ArrayList<>();

		Integer[] intArray = new Integer[10];
		intArray[0] = 1;
		intArray[1] = 3;

		count.add(intArray);

		int total = 10;

		Mockito.when(buyPolicyRepository.getPolicyNameAndCount()).thenReturn(count);
		Mockito.when(buyPolicyRepository.getTotalCount()).thenReturn(total);

		Mockito.when(policyRepository.findByPolicyId(Mockito.anyInt())).thenReturn(policy);
		List<TrendingResponseDTO> viewInvitationListactual = trendServiceImpl.getTrendingPolicies();
		assertEquals(1, viewInvitationListactual.size());

	}

	@Test
	public void getAllSuggestionTest() {

		List<SuggestionResponseDto> trendingResponseList = new ArrayList<>();
		SuggestionResponseDto trendingResponseDTO = new SuggestionResponseDto();
		trendingResponseDTO.setPolicyName("AYYANAR");
		trendingResponseList.add(trendingResponseDTO);

		Policy policy = new Policy();
		policy.setPolicyId(1);

		List<Integer[]> count = new ArrayList<>();

		Integer[] intArray = new Integer[10];
		intArray[0] = 1;
		intArray[1] = 3;

		count.add(intArray);

		Mockito.when(buyPolicyRepository.findByBuyPolicy()).thenReturn(count);

		Mockito.when(policyRepository.findByPolicyId(Mockito.anyInt())).thenReturn(policy);
		List<SuggestionResponseDto> viewInvitationListactual = trendServiceImpl.getAllSuggestion();
		assertEquals(1, viewInvitationListactual.size());

	}

}
