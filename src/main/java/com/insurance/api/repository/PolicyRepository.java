package com.insurance.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.api.entity.Policy;
/**
 * 
 * @author Sushil
 *
 */
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {
	
	public Policy findByPolicyId(int id);

}
