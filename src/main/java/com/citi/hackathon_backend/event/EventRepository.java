package com.citi.hackathon_backend.event;

import com.citi.hackathon_backend.event.entity.Event;
import org.springframework.data.repository.CrudRepository;
@org.socialsignin.spring.data.dynamodb.repository.EnableScan
public interface EventRepository extends CrudRepository<Event, Long> {
}
