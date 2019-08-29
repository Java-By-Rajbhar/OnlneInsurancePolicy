package com.insurance.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.api.entity.TermAndCondition;

public interface TermsAndConditionRepository extends JpaRepository<TermAndCondition, Integer> {
	
	
	public List<TermAndCondition> findByMinEntryAgeLessThanEqual(int age);
	
	public TermAndCondition findByPolicyId(int id);

}
