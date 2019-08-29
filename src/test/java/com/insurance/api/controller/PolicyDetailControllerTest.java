package com.insurance.api.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.api.dto.PolicyDetailsDto;
import com.insurance.api.service.PolicyDetailsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PolicyDetailControllerTest {
	
	@InjectMocks
	PolicyDetailController policyDetailController;

	private MockMvc mockMvc;
	
	@Mock
	private PolicyDetailsServiceImpl policyDetailsServiceImpl;

	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(policyDetailController).build();
	}
	
	@Test
	public void policyDetailsTest() throws Exception
	{
		PolicyDetailsDto  dto = new PolicyDetailsDto();
		dto.setPolicyId(100);
		dto.setPolicyName("insurance");
		
		Mockito.when(policyDetailsServiceImpl.policyDetails(Mockito.anyInt())).thenReturn(dto);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/policy/100").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(100))).andReturn();
		ResponseEntity<PolicyDetailsDto> response = policyDetailController.policyDetails(100);
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
