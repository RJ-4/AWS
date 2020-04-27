package com.rishabh.practice.aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.practice.aws.entity.Wizard;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Long>{

	Wizard findByNameIgnoreCaseContaining(String name); 
}
