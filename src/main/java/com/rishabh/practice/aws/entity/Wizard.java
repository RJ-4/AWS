package com.rishabh.practice.aws.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "wizard")
public class Wizard {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotEmpty(message = "Wizard name cannot be empty")
	private String name;
	
	@Column
	@Min(value = 1, message = "Wizard age cannot be less than 1")
	private Integer age;
	
	@JsonIgnoreProperties("wizard")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id")
	@Valid
	private Skill skill;
	
	@Column
	@NotEmpty(message = "Wizard threat level cannot be empty")
	@JsonProperty("threat_level")
	private String threatLevel;
}
