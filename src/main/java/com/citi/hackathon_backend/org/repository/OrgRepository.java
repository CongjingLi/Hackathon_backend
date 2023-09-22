package com.citi.hackathon_backend.org.repository;

import com.citi.hackathon_backend.org.entity.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrgRepository extends CrudRepository<Organization, String>{
	
}
