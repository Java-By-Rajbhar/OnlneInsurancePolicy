package com.insurance.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.api.dto.TrendingResponseDTO;
import com.insurance.api.service.TrendService;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class TrendController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TrendController.class);
	@Autowired
	TrendService trendService;
	
	@GetMapping("/trendDetails")
	public ResponseEntity<List<TrendingResponseDTO>> getTrendingPolicies(){
		List<TrendingResponseDTO> policyLists = trendService.getTrendingPolicies();
		return new ResponseEntity<>(policyLists,HttpStatus.OK);
	}
}
