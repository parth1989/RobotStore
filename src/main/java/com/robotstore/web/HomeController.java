

package com.robotstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robotstore.domain.Robot;
import com.robotstore.service.RobotStoreService;

/**
* <h1>Robot Store</h1>
* HomeController program  handle the request  and response of Robot store.
* @author  Parth kothari
* @version 1.0
* @since   14-07-2017
*/
@RestController
public class HomeController {

	@Autowired
    RobotStoreService robotStoreService;
	
	/**
	 * this method is used to get specific robot  based on name.
	 * @param name
	 * @return get robot object.
	 */
	@RequestMapping("/getRobotDetails/{name}")
	public Robot getRobot(@PathVariable String name) {
		return robotStoreService.getRobotDetail(name);
	}
	
	/**
	 * method is used to get all robots from database
	 * @return list of robots
	 */
	@RequestMapping("/findAllRobots")
	public List<Robot> findAllRobots() {
		return (List<Robot>) robotStoreService.findAllRobots();
	}
}
