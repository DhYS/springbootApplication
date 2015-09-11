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
		model.addAttribute("report", getCurrent());
		model.addAttribute("reportNumber", getNumber());
		model.addAttribute("reportIndex", getIndex());
		return "pptView";
	}
	
	@RequestMapping(value="ppt-view", method=RequestMethod.GET)
	public String searchPPTView(HttpServletRequest request, Model model) {
		if (request.getParameter("input") != null && !request.getParameter("input").equals("Address Search")) {
			currentReport = searchByFilter(1, request.getParameter("input"), report.getAllList());
			if (currentReport.size() > 0) {
				model.addAttribute("report", getCurrent());
			} else {
				model.addAttribute("alertMessage", "alert('No result found!');");
				currentReport = getAllList();
				model.addAttribute("report", getCurrent());
			}
		} else if (request.getParameter("input") == null || request.getParameter("input").equals("Address Search")) {
			currentReport = getAllList();
			model.addAttribute("report", getCurrent());
		}
		model.addAttribute("reportNumber", getNumber());
		model.addAttribute("reportIndex", getIndex());
		return "pptView";
	}
	
	@RequestMapping(value="ppt-view", method=RequestMethod.POST)
	public String nextPPTView(HttpServletRequest request, Model model) {
		int temp = index;
		if (request.getParameter("next") != null)
			next();
		else if (request.getParameter("previous") != null)
			previous();
		else if (request.getParameter("page") != null)
			index = setIndex(Integer.parseInt(request.getParameter("page number")));
		if (index == -1) {
			model.addAttribute("alertMessage", "alert('Out of index!');");
			index = temp;
		}
		model.addAttribute("reportNumber", getNumber());
		model.addAttribute("reportIndex", getIndex());
		model.addAttribute("report", getCurrent());
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
	
	// below is added from SpringbootApplication.java
	// this is not required if having database support, it is for search/filter purpose
	static List<StateInfo> currentReport;
	static final CsvObject report = new CsvObject();
	static int index;

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
		currentReport = report.getAllList();
		index = 1;

		System.out.println("Ready to go!");
		// System.out.println(report.getByIndex(500));
		// this is a test for direct id search
		// System.out.println(report.filter(1, "76002").get(0).toString());
		// this is a test for filter
	}

	// in case for future functionality 
	private StateInfo searchByIndex(int i) {
		System.out.println(report.getByIndex(i).toString());
		return report.getByIndex(i);
	}

	// multiple search filter
	private List<StateInfo> searchByFilter(int property, CharSequence criteria, List<StateInfo> listIn) {
		currentReport = report.filter(property, criteria, listIn);
		index = 1;
		return currentReport;
	}

	private List<StateInfo> getAllList() {
		index = 1;
		return report.getAllList();
	}
	
	private void next() {
		if (index < currentReport.size())
			index++;
	}
	
	private void previous() {
		if (index > 1)
			index--;
	}
	
	private StateInfo getCurrent() {
		return currentReport.get(index);
	}
	
	public String getNumber() {
		return Integer.toString(currentReport.size());
	}
	
	private int setIndex(int i) {
		if (1 < i && i < currentReport.size())
			return i;
		return -1;
	}
	
	public String getIndex() {
		return Integer.toString(index);
	}
}
