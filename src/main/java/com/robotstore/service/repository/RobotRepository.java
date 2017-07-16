
package com.robotstore.service.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.robotstore.domain.Robot;

@RestResource(path = "robot")
public interface RobotRepository extends CrudRepository<Robot, Long> {

    Robot findByName(String name);

	Page<Robot> findByNameContainingAllIgnoringCase(String name, Pageable pageable);

}
