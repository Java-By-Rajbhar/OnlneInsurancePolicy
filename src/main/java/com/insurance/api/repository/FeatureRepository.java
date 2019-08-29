package com.insurance.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.api.entity.Feature;

/**
 * @author Laxman
 *
 */
public interface FeatureRepository extends JpaRepository<Feature, Integer> {
	
	public List<Feature> findByPolicyId(Integer policyId);

}
