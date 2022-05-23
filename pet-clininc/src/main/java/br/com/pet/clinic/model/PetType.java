package br.com.pet.clinic.model;

import org.springframework.context.annotation.EnableMBeanExport;

public class PetType {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
