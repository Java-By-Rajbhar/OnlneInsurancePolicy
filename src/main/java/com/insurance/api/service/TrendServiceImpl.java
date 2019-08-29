package com.insurance.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.api.controller.TrendController;
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
	
	
		int total=buyPolicyRepository.getTotalCount();
		LOGGER.info("totalcount ={}",total);
		for (Integer[] integers : count) {
			int policyId = integers[0];
			int count2 = (int) integers[1];
			Policy Policy = policyRepository.findByPolicyId(policyId);
			TrendingResponseDTO trendOneByOne = new TrendingResponseDTO();

			trendOneByOne.setCount(count2);
			trendOneByOne.setPolicyName(Policy.getPolicyName());
			trendOneByOne.setTotalCount(total);
			double percenatage=(100/total);
					double totalpercent= count2*percenatage;
					LOGGER.info("totalpercent ={}",totalpercent);
			trendsList.add(trendOneByOne);

		}

		return trendsList;
	}

}
