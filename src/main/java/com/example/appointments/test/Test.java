package com.example.appointments.test;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @SequenceGenerator(
            name = "test_sequence",
            sequenceName = "test_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "test_sequence"
    )
    private Long test_id;
    private String test_str;

    public Test(String test_str) {
        this.test_str = test_str;
    }

    public Test() {
    }


    public Test(Long test_id, String test_str) {
        this.test_id = test_id;
        this.test_str = test_str;
    }

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public String getTest_str() {
        return test_str;
    }

    public void setTest_str(String test_str) {
        this.test_str = test_str;
    }


}
