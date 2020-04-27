package com.rishabh.practice.aws.service;

import java.util.List;

import com.rishabh.practice.aws.entity.Wizard;

public interface WizardService {

	Wizard findByName(String name);

	Wizard findById(Long id);
	
	Wizard addWizard(Wizard wizard);

	List<Wizard> findAll();
}
