package com.springbootapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

//import com.springbootapplication.applications.SpringbootApplication;
import com.springbootapplication.controllers.HomeController;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SpringbootApplication.class)
@SpringApplicationConfiguration(classes = HomeController.class)
@WebAppConfiguration
public class SpringbootApplicationTests {

	@Test
	public void contextLoads() {
	}

}
