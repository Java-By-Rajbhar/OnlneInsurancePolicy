package com.insurance.api.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.insurance.api.dto.SuggestionResponseDto;
import com.insurance.api.dto.TrendingResponseDTO;
import com.insurance.api.service.TrendService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TrendControllerTest {

	@Mock
	TrendService trendService;

	@InjectMocks
	TrendController trendController;

	private MockMvc mockMvc;


	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(trendController).build();
	}

	

	@Test
	public void getTrendingPoliciesTest() throws Exception {
		List<TrendingResponseDTO> trendingResponseList = new ArrayList<>();
		TrendingResponseDTO trendingResponseDTO = new TrendingResponseDTO();
		
		trendingResponseDTO.setCount(2);
		trendingResponseDTO.setPolicyName("Ajith");
		trendingResponseDTO.setTotalCount(45);
		trendingResponseList.add(trendingResponseDTO);
		

		Mockito.when(trendService.getTrendingPolicies()).thenReturn(trendingResponseList);
		ResponseEntity<List<TrendingResponseDTO>> trendingResponseDTO2 = trendController.getTrendingPolicies();
		
		assertEquals(1, trendingResponseDTO2.getBody().size());
	}
	
	@Test
	public void getSuggestionTest() throws Exception {
		List<SuggestionResponseDto> suggestionList = new ArrayList<>();
		SuggestionResponseDto suggestion = new SuggestionResponseDto();
		
		suggestion.setPolicyName("Ajith");
		suggestionList.add(suggestion);
		
		Mockito.when(trendService.getAllSuggestion()).thenReturn(suggestionList);
		ResponseEntity<List<SuggestionResponseDto>> suggestionList2 = trendController.getSuggestion();
		
		assertEquals(1, suggestionList2.getBody().size());
	}

}
