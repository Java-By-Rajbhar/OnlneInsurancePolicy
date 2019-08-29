package com.insurance.api.service;

import java.util.List;

import com.insurance.api.dto.SuggestionResponseDto;
import com.insurance.api.dto.TrendingResponseDTO;

public interface TrendService {

	List<TrendingResponseDTO> getTrendingPolicies();

	List<SuggestionResponseDto> getAllSuggestion();

}
