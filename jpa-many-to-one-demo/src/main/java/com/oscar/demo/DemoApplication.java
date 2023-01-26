package com.oscar.demo;

import com.oscar.demo.entities.Example;
import com.oscar.demo.entities.ExampleDetail;
import com.oscar.demo.repository.ExampleRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
			ExampleDetail detailA = new ExampleDetail();
			detailA.setData("detail-data-a");

			ExampleDetail detailB = new ExampleDetail();
			detailB.setData("detail-data-b");

			Example example = new Example("data-1", List.of(detailA, detailB));

			repository.save(example);

			repository.findAll().forEach(ex -> {
				if (ex.getExampleDetailList().size() == 2) {
					log.info("Correct number of details");
				} else {
					log.error("Different number of details than expected");
				}

				Set<String> dataSet = ex.getExampleDetailList().stream()
						.map(ExampleDetail::getData)
						.collect(Collectors.toSet());

				if (dataSet.equals(Set.of("detail-data-a", "detail-data-b"))) {
					log.info("Data in details is correct");
				} else {
					log.error("Error in detail data");
				}
			});

		};
	}

}
