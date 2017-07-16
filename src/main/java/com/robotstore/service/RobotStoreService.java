package com.robotstore.service;

import java.util.List;

import com.robotstore.domain.Robot;

public interface RobotStoreService {
    Robot getRobotDetail(String name);
    List<Robot> findAllRobots();
}
