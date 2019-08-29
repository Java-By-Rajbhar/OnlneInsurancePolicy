package com.insurance.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.api.dto.PolicyDetailsDto;
import com.insurance.api.service.PolicyDetailsService;

/**
 * @author Laxman
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class PolicyDetailController {

	@Autowired
	private PolicyDetailsService policyDetailsService;
	
	@GetMapping("/policy/{policyId}")
	public ResponseEntity<PolicyDetailsDto> policyDetails(@PathVariable Integer policyId){
		return new ResponseEntity<>(policyDetailsService.policyDetails(policyId), HttpStatus.OK);
	}
}
