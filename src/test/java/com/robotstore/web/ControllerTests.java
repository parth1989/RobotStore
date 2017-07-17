package com.robotstore.web;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.robotstore.ApplicationEntry;

import java.nio.file.Files;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration test to run the application.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationEntry.class)
@WebAppConfiguration
@ActiveProfiles("scratch")
// Separate profile for web tests to avoid clashing databases
public class ControllerTests {

	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
	
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testHome() throws Exception {
		this.mvc.perform(get("/")).andExpect(status().isOk());
	}

    @Test
    public void testGetRobot() throws Exception {
        this.mvc.perform(get("/robot/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetRobot1() throws Exception {
        this.mvc.perform(get("/robot/1")).andExpect(status().isOk());
    }
    
    @Test
    public void testGetRobotDetails() throws Exception {
        this.mvc.perform(get("/getRobotDetails/R-1")).andExpect(status().isOk());
    }

    @Test
    public void testSaveRobot() throws Exception {

        ClassPathResource resource = new ClassPathResource("robot.json");
        byte[] data = Files.readAllBytes(resource.getFile().toPath());

        this.mvc.perform(post("/robot").contentType(MediaType.APPLICATION_JSON).content(data)).
                andExpect(status().isCreated()).
                andExpect(header().string("Location", is(notNullValue()))).
                andReturn().getResponse();
    }

  


}
