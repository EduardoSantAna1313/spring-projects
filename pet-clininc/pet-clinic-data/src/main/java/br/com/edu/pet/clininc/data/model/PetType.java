package br.com.edu.pet.clininc.data.model;

import org.springframework.context.annotation.EnableMBeanExport;

public class PetType extends BaseEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
