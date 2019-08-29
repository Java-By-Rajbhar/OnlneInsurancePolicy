package com.insurance.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.api.dto.BuyPolicyRequestDto;
import com.insurance.api.dto.BuyPolicyResponseDto;
import com.insurance.api.entity.BuyPolicy;
import com.insurance.api.entity.PolicyHolder;
import com.insurance.api.repository.BuyPolicyRepository;
import com.insurance.api.repository.PolicyHolderRepository;
import com.insurance.api.repository.PolicyRepository;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	BuyPolicyRepository buyPolicyRepository;
	
	
	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	PolicyHolderRepository PolicyHolderRepository;
	
	@Autowired
	MailService mailservice;
	
	
	@Override
	public BuyPolicyResponseDto buyPolicy(BuyPolicyRequestDto buyPolicyRequestDto) {
		BuyPolicyResponseDto buyPolicyResponseDto=new BuyPolicyResponseDto();
		
		if(isValidEmailAddress(buyPolicyRequestDto.getEmail()))
		{
			PolicyHolder policyHolder=new PolicyHolder();
			
			policyHolder.setAge(buyPolicyRequestDto.getAge());
			policyHolder.setEmailId(buyPolicyRequestDto.getEmail());
			policyHolder.setEmpId(buyPolicyRequestDto.getEmpId());
			policyHolder.setGender(buyPolicyRequestDto.getGender());
			policyHolder.setName(buyPolicyRequestDto.getName());
			policyHolder.setRelationship(buyPolicyRequestDto.getRelationship());
			PolicyHolder saveData=PolicyHolderRepository.save(policyHolder);
			
			
			
			
			
			BuyPolicy buyPolicy=new BuyPolicy();
			buyPolicy.setCustomerId(saveData.getCustomerId());
			buyPolicy.setPolicyId(buyPolicyRequestDto.getPolicyId());
			buyPolicy.setPurchaseDate(new Date());
			
			buyPolicyRepository.save(buyPolicy);

			
			buyPolicyResponseDto.setMessage("Congrats!!Policy is bought");
			buyPolicyResponseDto.setStatusCode(200);
			buyPolicyResponseDto.setStatus("Success");
			
		}
		else
		{
			buyPolicyResponseDto.setMessage("email id in valid");
			buyPolicyResponseDto.setStatusCode(404);
			buyPolicyResponseDto.setStatus("Failed");
		}
		
		
				
		return buyPolicyResponseDto;
		
	}
	
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }

}
