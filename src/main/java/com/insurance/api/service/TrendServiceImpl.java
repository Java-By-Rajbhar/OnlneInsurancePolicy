package com.insurance.api.service;

import java.util.ArrayList;
import java.util.List;

import com.insurance.api.dto.TrendingResponseDTO;

public class TrendServiceImpl implements TrendService {

	@Override
	public List<TrendingResponseDTO> getTrendingPolicies() {
		List<TrendingResponseDTO> trendsList= new ArrayList<>();
		
		TrendingResponseDTO trendOneByOne = new TrendingResponseDTO();
		
		/*
		 * List<Integer[]> count = buypolicyRepository.getTrendingPolicies(); for
		 * (trendsList )
		 * 
		 * TrendingResponseDTO.set
		 */
		
		return trendsList;
	}

}
