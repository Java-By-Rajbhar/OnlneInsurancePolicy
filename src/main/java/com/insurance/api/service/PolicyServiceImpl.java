package com.insurance.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.api.dto.PolicyResponseDto;
import com.insurance.api.entity.Policy;
import com.insurance.api.entity.TermAndCondition;
import com.insurance.api.repository.PolicyRepository;
import com.insurance.api.repository.TermsAndConditionRepository;

/**
 * 
 * @author Sushil
 *
 */

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private TermsAndConditionRepository termsAndConditionRepository;
	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public List<PolicyResponseDto> policyList(int age) {
		
		List<PolicyResponseDto> listReponse=new ArrayList<>();
	

		if (age == 1) {
			List<Policy> policyList=policyRepository.findAll();
			for (Policy policy : policyList) {
				PolicyResponseDto policyResponseDto=new PolicyResponseDto();
				
				TermAndCondition termAndCondition=	termsAndConditionRepository.findByPolicyId(policy.getPolicyId());
				policyResponseDto.setPolicyId(policy.getPolicyId());
				policyResponseDto.setPolicyName(policy.getPolicyName());
				String entryAge=termAndCondition.getMinEntryAge()+"-"+termAndCondition.getMaxEntryAge();
				policyResponseDto.setEntryAge(entryAge);
				policyResponseDto.setMaxMaturity(termAndCondition.getMaxMaturity());
				policyResponseDto.setPolicyTerm(termAndCondition.getPolicyTerm());
				listReponse.add(policyResponseDto);
			}
		}
		else
		{
			List<TermAndCondition> termAndConditionList=termsAndConditionRepository.findByMinEntryAgeLessThanEqual(age);
			List<Policy> policyList=new ArrayList<>();
			for (TermAndCondition termAndCondition : termAndConditionList) {
				
				Policy policy=policyRepository.findByPolicyId(termAndCondition.getPolicyId());
				policyList.add(policy);
				
			}
			for (Policy policy : policyList) {
				PolicyResponseDto policyResponseDto=new PolicyResponseDto();
				TermAndCondition termAndCondition=	termsAndConditionRepository.findByPolicyId(policy.getPolicyId());
				policyResponseDto.setPolicyId(policy.getPolicyId());
				policyResponseDto.setPolicyName(policy.getPolicyName());
				String entryAge=termAndCondition.getMinEntryAge()+"-"+termAndCondition.getMaxEntryAge();
				policyResponseDto.setEntryAge(entryAge);
				policyResponseDto.setMaxMaturity(termAndCondition.getMaxMaturity());
				policyResponseDto.setPolicyTerm(termAndCondition.getPolicyTerm());
				listReponse.add(policyResponseDto);
			
			  }
			}
			
		
		return listReponse;
	}

}
