package com.insurance.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.api.service.PolicyService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
public class PolicyController {
private static final Logger LOGGER = LoggerFactory.getLogger(PolicyController.class);
	@Autowired
	PolicyService policyService;
}
