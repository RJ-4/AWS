package com.rishabh.practice.aws.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.practice.aws.entity.Wizard;
import com.rishabh.practice.aws.repository.WizardRepository;
import com.rishabh.practice.aws.service.WizardService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class WizardServiceImpl implements WizardService {

	@Autowired
	private WizardRepository wizardRepository;
	
	@Override
	public Wizard findById(Long id) {
		log.info("Fetching wizard with id: " + id);
		return wizardRepository.findById(id)
								.orElse(null);
	}
	
	@Override
	public Wizard findByName(String name) {
		
		log.info("Fetching wizard with name: " + name);
		return wizardRepository.findByNameIgnoreCaseContaining(name);
	}

	@Override
	public Wizard addWizard(Wizard wizard) {

		log.info("Adding new wizard: " + wizard);
		return wizardRepository.save(wizard);
	}
	
	@Override
	public List<Wizard> findAll() {
		
		log.info("Fetching all wizards");
		return wizardRepository.findAll();
	}
}
