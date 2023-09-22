package com.citi.hackathon_backend.org.repository;

import com.citi.hackathon_backend.org.entity.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
@Repository
public interface OrgRepository extends CrudRepository<Organization, String>{
	
}
