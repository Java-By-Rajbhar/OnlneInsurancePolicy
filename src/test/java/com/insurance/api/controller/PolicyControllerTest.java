package com.insurance.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

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
import com.insurance.api.dto.PolicyResponseDto;
import com.insurance.api.service.PolicyService;


@RunWith(SpringJUnit4ClassRunner.class)
public class PolicyControllerTest {

	
	@Mock
	PolicyService policyService;
	
	@InjectMocks
	PolicyController policyController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(policyController).build();
	}
	
	
	@Test
	public void test() throws Exception {
		List<PolicyResponseDto> repo=new ArrayList<>();
		PolicyResponseDto policyResponseDto=new PolicyResponseDto();
		policyResponseDto.setEntryAge("18-65");
		policyResponseDto.setMaxMaturity("100000 Rs");
		policyResponseDto.setPolicyId(1);
		policyResponseDto.setPolicyName("policy1");
		policyResponseDto.setPolicyTerm("Yes");
		
		repo.add(policyResponseDto);
		when(policyService.policyList(Mockito.anyInt())).thenReturn(repo);
		

		mockMvc.perform(MockMvcRequestBuilders.post("/policies/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(""))).andReturn();

		ResponseEntity<List<PolicyResponseDto>> actual=policyController.policies(1);
		assertEquals(1, actual.getBody().size());
	
	}
	
	public static String asJsonString(final Object obj) {

		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
