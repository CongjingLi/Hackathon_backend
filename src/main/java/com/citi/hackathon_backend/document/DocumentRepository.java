package com.citi.hackathon_backend.document;

import com.citi.hackathon_backend.document.entity.UserDocument;
import com.citi.hackathon_backend.event.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
@Repository
public interface DocumentRepository extends CrudRepository<UserDocument, String> {
    public UserDocument findByName(String name);
}
