package com.springbootapplication.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbootapplication.objects.StateInfo;
import com.springbootapplication.objects.CsvObject;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class HomeController {
	
	@RequestMapping({"/","home"})
	public String home(@ModelAttribute("user") CsvObject report) {
		return "home";
	}
	
	@RequestMapping("ppt-view")
	public String PPTView(Model model) {
		model.addAttribute("report", report);
		return "pptView";
	}
	
	@RequestMapping(value="ppt-view", method=RequestMethod.POST)
	public String nextPPTView(HttpServletRequest request, Model model) {
		if (request.getParameter("next") != null)
			report.next();
		else if (request.getParameter("previous") != null)
			report.previous();
		model.addAttribute("report", report);
		return "pptView";
	}

	@RequestMapping("search")
	public String search() {
		return "search";
	}

	@RequestMapping("about")
	public String about() {
		return "about";
	}
	
	// below is added from application
	
	static CsvObject report = new CsvObject();
	int index = 0;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HomeController.class, args);

		System.out.println("Beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		System.out.println("Application is running!");
		
		// Read input file from here
		report.readCsv("report.csv", ",");

		System.out.println("Ready to go!");
		// System.out.println(report.getByIndex(500));
		// this is a test for direct id search
		// System.out.println(report.filter(1, "76002").get(0).toString());
		// this is a test for filter
	}

	// in case for future functions
	public StateInfo searchByIndex(int i) {
		System.out.println(report.getByIndex(i).toString());
		return report.getByIndex(i);
	}

	public List<StateInfo> SearchByFilter(int property, CharSequence criteria) {
		return report.filter(property, criteria);
	}

	public List<StateInfo> getAllList() {
		return report.getAllList();
	}
	
	public void next() {
		report.next();
	}
	
	public void previous() {
		report.previous();
	}
}
