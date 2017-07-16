package com.robotstore.service;


import com.robotstore.ApplicationEntry;
import com.robotstore.domain.Robot;
import com.robotstore.service.repository.RobotRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationEntry.class)
public class RobotIntegrationTests {

	@Autowired
    RobotRepository repository;

    @Test
    public void getRobotById(){
        Robot robot = this.repository.findOne(1l);
        assertThat(robot.getId(), is(equalTo(1l)));
        assertThat(robot.getName(), is(equalTo("R-1")));
    }

    @Test
    public void saveProduct(){
    	Robot robot = new Robot();
    	robot.setName("Robot-1");
        Robot savedRobot = repository.save(robot);

        assertThat(savedRobot.getId(), notNullValue());
        assertThat(savedRobot.getName(), is(equalTo(robot.getName())));
    }
}
