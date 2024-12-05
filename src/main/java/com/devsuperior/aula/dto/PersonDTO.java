package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Person;



public class PersonDTO {
    
    private Long id;
    private String name;
    private Double salary;    
    private DepartmentDTO department;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, Double salary, DepartmentDTO department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public PersonDTO(Person entity){
        id = entity.getId();
        name = entity.getName();
        salary = entity.getSalary();
        department = new DepartmentDTO(entity.getDepartment());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    
}
