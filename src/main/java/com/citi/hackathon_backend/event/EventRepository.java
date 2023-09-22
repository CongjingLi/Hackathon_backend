package com.citi.hackathon_backend.event;

import com.citi.hackathon_backend.event.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
@Repository
public interface EventRepository extends CrudRepository<Event, String> {
}
