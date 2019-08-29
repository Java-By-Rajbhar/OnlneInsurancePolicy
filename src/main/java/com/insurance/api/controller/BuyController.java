package com.insurance.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.api.dto.BuyPolicyRequestDto;
import com.insurance.api.dto.BuyPolicyResponseDto;
import com.insurance.api.service.BuyService;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class BuyController {
	
	@Autowired
	private BuyService buyService;
	
	@PostMapping("/buyPolicy")
	public ResponseEntity<BuyPolicyResponseDto> buyPolicy(@RequestBody BuyPolicyRequestDto buyPolicyRequestDto)
	{
		
		
		return new ResponseEntity<>(buyService.buyPolicy(buyPolicyRequestDto),HttpStatus.OK);
	}

}
