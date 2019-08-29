package com.insurance.api.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Laxman
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeatureDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int featureId;
	private String featureName;
	private String featureDescription;

}
