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
 * @author Laxman
 *
 */
@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Feature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int featureId;
	private int policyId;
	private String featureName;
	private String featureDescription;

}
