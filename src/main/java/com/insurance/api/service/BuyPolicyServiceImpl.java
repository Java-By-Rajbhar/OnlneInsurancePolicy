package com.insurance.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.api.dto.PolicyAnalysisResponseDto;
import com.insurance.api.entity.Policy;
import com.insurance.api.repository.BuyPolicyRepository;
import com.insurance.api.repository.PolicyRepository;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class BuyPolicyServiceImpl implements BuyPolicyService {
	
private static final Logger LOGGER = LoggerFactory.getLogger(BuyPolicyServiceImpl.class);

	@Autowired
	BuyPolicyRepository buyPolicyRepository;
	@Autowired
	PolicyRepository policyRepository;
	@Override
	public PolicyAnalysisResponseDto analysis() {
	       LOGGER.info("Inside analysis method of PurchasePrudectServiceImpl class");
	        List<Integer[]> response = buyPolicyRepository.getPolicyNameAndCount();
	        List<String>  policyName = new ArrayList<>();
	        List<Integer>  policyCount = new ArrayList<>();
	        LOGGER.info("count data ={}",response.size());
	        
	        response.forEach(data->{
	            int policyId =  data[0];
	            int count  = (int) data[1];
	            Policy policy = policyRepository.findByPolicyId(policyId);
	            LOGGER.info("product name ={}",policy.getPolicyName());
	            policyName.add(policy.getPolicyName());
	            policyCount.add(count);
	        });
	        LOGGER.info("product list={}",policyName);
	        LOGGER.info("product count={}",policyCount);
	        PolicyAnalysisResponseDto dto =  new  PolicyAnalysisResponseDto();
	        dto.setPolicyCount(policyCount);
	        dto.setPolicyName(policyName);
	        return dto;
	}
	
	

}
