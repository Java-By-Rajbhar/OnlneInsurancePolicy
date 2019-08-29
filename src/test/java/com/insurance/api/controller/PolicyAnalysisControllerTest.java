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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.api.dto.PolicyAnalysisResponseDto;
import com.insurance.api.service.BuyPolicyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class PolicyAnalysisControllerTest {
	
	@InjectMocks
	PolicyAnalysisController analysisController;

	private MockMvc mockMvc;
	@Mock
	BuyPolicyServiceImpl buyPolicyServiceImpl;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(analysisController).build();
	}
	
	@Test
	public void ProductControllerTest() throws Exception
	{
		PolicyAnalysisResponseDto dto = new PolicyAnalysisResponseDto();
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		dto.setPolicyCount(list);
		List<String> list1 = new ArrayList<>();
		list1.add("insurance");
		list1.add("insurance1");
		dto.setPolicyName(list1);
		
		Mockito.when(buyPolicyServiceImpl.analysis()).thenReturn(dto);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/trends").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(""))).andReturn();
		ResponseEntity<PolicyAnalysisResponseDto> response = analysisController.analysis();
		
		assertEquals(200, response.getStatusCodeValue());
	}
	
	public static String asJsonString(final Object obj) {

		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
