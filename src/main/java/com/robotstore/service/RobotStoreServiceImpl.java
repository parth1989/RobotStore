package com.robotstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotstore.domain.Robot;
import com.robotstore.service.repository.RobotRepository;


@Service
public class RobotStoreServiceImpl implements RobotStoreService {

    @Autowired
    RobotRepository robotRepository;

  
    @Override
    public Robot getRobotDetail(String name) {
    	System.out.println("enter in service :::");
        Robot robot = robotRepository.findByName(name);
        return robot;
    }


	@Override
	public List<Robot> findAllRobots() {
		return (List<Robot>) robotRepository.findAll();
		
	}
}