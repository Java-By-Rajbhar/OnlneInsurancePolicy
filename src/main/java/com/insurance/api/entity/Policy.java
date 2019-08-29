package com.insurance.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int policyId;
	private String policyName;
	private String description;

}
