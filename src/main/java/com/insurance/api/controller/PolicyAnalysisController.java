package com.insurance.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.api.dto.PolicyAnalysisResponseDto;
import com.insurance.api.service.BuyPolicyService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class PolicyAnalysisController {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(PolicyAnalysisController.class);
	
	@Autowired
	BuyPolicyService buyPolicyService;
	
	@GetMapping("/trends")
	public ResponseEntity<PolicyAnalysisResponseDto> analysis(){
		LOGGER.info("Inside analysis method of PolicyAnalysisController class");
		PolicyAnalysisResponseDto response = buyPolicyService.analysis();
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
