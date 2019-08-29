package com.insurance.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurance.api.entity.BuyPolicy;

@Repository
public interface BuyPolicyRepository extends JpaRepository<BuyPolicy, Integer> {

	@Query(value="select policy_id, count(policy_id) as count from inginsurance.buy_policy group by policy_id",nativeQuery = true)
	public List<Integer[]> getPolicyNameAndCount();
}
