package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Person;



public class PersonDTO2 {
    
    private Long id;
    private String name;
    private Double salary;    
    private Long departmentId;

    public PersonDTO2() {
    }

    public PersonDTO2(Long id, String name, Double salary, Long departmentId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public PersonDTO2(Person entity){
        id = entity.getId();
        name = entity.getName();
        salary = entity.getSalary();
        departmentId = entity.getDepartment().getId();
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

    public Long getDepartmentId() {
        return departmentId;
    }

    
}
