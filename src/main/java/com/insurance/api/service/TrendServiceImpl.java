package com.insurance.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.api.controller.TrendController;
import com.insurance.api.dto.SuggestionResponseDto;
import com.insurance.api.dto.TrendingResponseDTO;
import com.insurance.api.entity.Policy;
import com.insurance.api.repository.BuyPolicyRepository;
import com.insurance.api.repository.PolicyRepository;

@Service

public class TrendServiceImpl implements TrendService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TrendController.class);
	@Autowired
	BuyPolicyRepository buyPolicyRepository;
	@Autowired
	PolicyRepository policyRepository;

	public List<TrendingResponseDTO> getTrendingPolicies() {
		List<TrendingResponseDTO> trendsList = new ArrayList<>();

		List<Integer[]> count = buyPolicyRepository.getPolicyNameAndCount();

		int total = buyPolicyRepository.getTotalCount();
		LOGGER.info("totalcount ={}", total);
		for (Integer[] integers : count) {
			int policyId = integers[0];
			int count2 = (int) integers[1];
			Policy Policy = policyRepository.findByPolicyId(policyId);
			TrendingResponseDTO trendOneByOne = new TrendingResponseDTO();

			trendOneByOne.setCount(count2);
			trendOneByOne.setPolicyName(Policy.getPolicyName());
			double percentage=(count2 / total) * 100;
			trendOneByOne.setTotalCount(percentage);
			trendsList.add(trendOneByOne);

		}

		return trendsList;
	}

	public List<SuggestionResponseDto> getAllSuggestion() {

		List<Integer[]> policyList = buyPolicyRepository.findByBuyPolicy();

		List<SuggestionResponseDto> SuggestionResponseDtoList = new ArrayList<>();
		for (Integer[] integers : policyList) {
			int policyId = integers[0];
			Policy Policy = policyRepository.findByPolicyId(policyId);
			SuggestionResponseDto trendOneByOne = new SuggestionResponseDto();

			trendOneByOne.setPolicyName(Policy.getPolicyName());

			SuggestionResponseDtoList.add(trendOneByOne);

		}

		return SuggestionResponseDtoList;
	}

}
