package com.oscar.demo.repository;

import com.oscar.demo.entities.Example;
import org.springframework.data.repository.CrudRepository;

public interface ExampleRepository extends CrudRepository<Example, Long> {
}
