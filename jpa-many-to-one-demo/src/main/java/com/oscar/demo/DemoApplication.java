package com.oscar.demo;

import com.oscar.demo.entities.Example;
import com.oscar.demo.entities.ExampleDetail;
import com.oscar.demo.repository.ExampleRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ExampleRepository repository) {
		return (args) -> {
			Example exampleA = new Example();

			ExampleDetail detailA = new ExampleDetail();
			detailA.setData("detail-data-a");

			ExampleDetail detailB = new ExampleDetail();
			detailB.setData("detail-data-b");

			exampleA.setData("data-1");
			exampleA.setExampleDetailList(List.of(detailA, detailB));

			repository.save(exampleA);

			repository.findAll().forEach(System.out::println);

		};
	}

}
