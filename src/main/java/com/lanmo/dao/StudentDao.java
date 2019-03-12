package com.lanmo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    private String label="1111111111111";


    public StudentDao() {
    }

    public StudentDao(String label) {
        this.label = label;
    }

    public String getLabel() {

        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "StudentDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
