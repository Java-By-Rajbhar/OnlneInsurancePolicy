package com.insurance.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.api.entity.PolicyHolder;

/**
 * 
 * @author Sushil
 *
 */
@Repository
public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Integer> {

}
