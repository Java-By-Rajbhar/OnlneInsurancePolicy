package com.insurance.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.api.dto.PolicyResponseDto;
import com.insurance.api.service.PolicyService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class PolicyController {
private static final Logger LOGGER = LoggerFactory.getLogger(PolicyController.class);
	@Autowired
	PolicyService policyService;
	
	
	@GetMapping("/policies/{age}")
	public ResponseEntity<List<PolicyResponseDto>> policies(@PathVariable int age)
	{
		
		
		return new ResponseEntity<>(policyService.policyList(age),HttpStatus.OK);
	}
}
