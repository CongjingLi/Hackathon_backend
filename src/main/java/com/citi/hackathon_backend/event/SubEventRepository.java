package com.citi.hackathon_backend.event;

import com.citi.hackathon_backend.event.entity.Event;
import com.citi.hackathon_backend.event.entity.SubEvent;
import org.springframework.data.repository.CrudRepository;
@org.socialsignin.spring.data.dynamodb.repository.EnableScan
public interface SubEventRepository extends CrudRepository<SubEvent, Long> {
}
