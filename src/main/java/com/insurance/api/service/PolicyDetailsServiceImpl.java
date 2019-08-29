package com.insurance.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.api.dto.FeatureDto;
import com.insurance.api.dto.PolicyDetailsDto;
import com.insurance.api.entity.Feature;
import com.insurance.api.entity.Policy;
import com.insurance.api.entity.TermAndCondition;
import com.insurance.api.repository.FeatureRepository;
import com.insurance.api.repository.PolicyRepository;
import com.insurance.api.repository.TermsAndConditionRepository;

@Service
public class PolicyDetailsServiceImpl implements PolicyDetailsService {

	@Autowired
	private FeatureRepository featureRepository;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private TermsAndConditionRepository termsAndConditionRepository;

	public PolicyDetailsDto policyDetails(Integer policyId) {
		Policy policy = policyRepository.findByPolicyId(policyId);
		List<Feature> features = featureRepository.findByPolicyId(policyId);
		TermAndCondition termAndCondition = termsAndConditionRepository.findByPolicyId(policyId);

		List<FeatureDto> featuresDto = new ArrayList<>();
		for (Feature feature : features) {
			FeatureDto featureDto = new FeatureDto();
			BeanUtils.copyProperties(feature, featureDto);
			featuresDto.add(featureDto);
		}

		PolicyDetailsDto policyDetailsDto = new PolicyDetailsDto();
		policyDetailsDto.setPolicyId(policy.getPolicyId());
		policyDetailsDto.setPolicyName(policy.getPolicyName());
		policyDetailsDto.setPolicyDescription(policy.getDescription());
		policyDetailsDto.setEntryAge(termAndCondition.getMinEntryAge() + "-" + termAndCondition.getMaxEntryAge());
		policyDetailsDto.setLoanFacility(termAndCondition.getLoanFacility());
		policyDetailsDto.setMaxMaturity(termAndCondition.getMaxMaturity());
		policyDetailsDto.setMaxPurchasePrice(termAndCondition.getMinPurchasePrice());
		policyDetailsDto.setMinPurchasePrice(termAndCondition.getMinPurchasePrice());
		policyDetailsDto.setPolicyTerm(termAndCondition.getPolicyTerm());
		policyDetailsDto.setSumAssured(termAndCondition.getSumAssured());
		policyDetailsDto.setTaxBenefits(termAndCondition.getTaxBenifits());
		policyDetailsDto.setFeaturs(featuresDto);
		return policyDetailsDto;
	}

}
