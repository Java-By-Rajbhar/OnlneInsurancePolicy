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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.api.dto.BuyPolicyRequestDto;
import com.insurance.api.dto.BuyPolicyResponseDto;
import com.insurance.api.dto.PolicyDetailsDto;
import com.insurance.api.service.BuyServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BuyControllerTest {
	
	@Mock
	BuyServiceImpl buyServiceImpl;
	
	@InjectMocks
	BuyController buyController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(buyController).build();
	}

	@Test
	public void testBuyPolicy() throws Exception {
		BuyPolicyResponseDto dto = new BuyPolicyResponseDto();
		dto.setMessage("hi");
		dto.setStatus("success");
		dto.setStatusCode(200);
		
		BuyPolicyRequestDto  dto2= new BuyPolicyRequestDto();
		dto2.setAge(20);
		dto2.setName("raja");
		Mockito.when(buyServiceImpl.buyPolicy(Mockito.any())).thenReturn(dto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/buyPolicy").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(dto2))).andReturn();
		
		ResponseEntity<BuyPolicyResponseDto> response = buyController.buyPolicy(dto2);
		assertEquals(200, response.getStatusCodeValue());
	}
	


}
