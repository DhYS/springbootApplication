/*package com.springbootapplication.applications;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.springbootapplication.objects.CsvObject;
import com.springbootapplication.controllers.HomeController;
import com.springbootapplication.objects.StateInfo;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class SpringbootApplication extends SpringBootServletInitializer {
	
	static CsvObject report = new CsvObject();
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootApplication.class);
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HomeController.class, args);

		System.out.println("Beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		System.out.println("Application is running!");

		//report.readCsv("report1441605211675.csv", ",");

		//System.out.println("Ready to go!");
		// System.out.println(report.getByIndex(500));
		// this is a test for direct id search
		// System.out.println(report.filter(1, "76002").get(0).toString());
		// this is a test for filter
	}

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
}
*/