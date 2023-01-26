package com.oscar.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Example {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String data;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ExampleDetail> exampleDetailList;

    public Example(String data, List<ExampleDetail> exampleDetailList) {
        this.exampleDetailList = exampleDetailList;
        this.data = data;
    }

    public Example() {

    }
}
