package com.rishabh.practice.aws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "skill")
public class Skill {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotEmpty(message = "Strength cannot be empty")
	private String strength;
	
	@Column
	@NotEmpty(message = "Speed cannot be empty")
	private String speed;
	
	@Column
	@NotEmpty(message = "Magic cannot be empty")
	private String magic;
	
	@Column
	@NotEmpty(message = "Control cannot be empty")
	private String control;
	
	@Column
	@NotEmpty(message = "Intelligence cannot be empty")
	private String intelligence;
	
	@JsonIgnoreProperties("skill")
	@OneToOne(mappedBy = "skill")
	@JoinColumn(name = "wizard_id")
	private Wizard wizard;
}
