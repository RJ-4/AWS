package com.rishabh.practice.aws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.practice.aws.api.response.ApiResponse;
import com.rishabh.practice.aws.entity.Wizard;
import com.rishabh.practice.aws.service.WizardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/wizards")
@Slf4j
public class WizardController {

	@Autowired
	private WizardService wizardService;
	
	@PostMapping("")
	public ApiResponse<Wizard> addWizard(@Valid @RequestBody Wizard wizard) {
		
		log.info("Receieved request to add new wizard: " + wizard);
		Wizard addedWizard = wizardService.addWizard(wizard);
		return new ApiResponse<>("Wizard added successfully", addedWizard);
	}
	
	@GetMapping("/{id}")
	public ApiResponse<Wizard> getWizardById(@PathVariable(value = "id", required = true) String id) {
		
		log.info("Recieved request to fetch wizard by id: " + id);
		Wizard fetchedWizard = wizardService.findById(Long.parseLong(id));
		if(fetchedWizard == null) {
			return new ApiResponse<Wizard>("No matching wizards found with id: " + id);
		}
		return new ApiResponse<Wizard>("Wizard fetched successfully", fetchedWizard);
	}
	
	@GetMapping("")
	public ApiResponse<Wizard> getWizardByName(@RequestParam(value = "name", required = false) String name) {
		
		log.info("Recieved request to fetch wizard by name: " + name);
		if(name == null || name.trim().equals("")) {
			List<Wizard> fetchedWizards = wizardService.findAll();
			if(fetchedWizards == null || fetchedWizards.isEmpty()) {
				return new ApiResponse<>("No wizards exist");
			}
			return new ApiResponse<>("Wizards fetched successfully", fetchedWizards);
		}
		Wizard fetchedWizard = wizardService.findByName(name);
		if(fetchedWizard == null) {
			return new ApiResponse<Wizard>("No matching wizards found with name: " + name);
		}
		return new ApiResponse<Wizard>("Wizard fetched successfully", fetchedWizard);
	}
}
