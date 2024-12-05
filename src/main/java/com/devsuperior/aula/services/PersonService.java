package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDTO2;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Salvar entidades associadas para-um
    // Com aninhamento de classes (Person e Department)
    public PersonDepartmentDTO insert(PersonDepartmentDTO dto){

        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());
        // Department dept = new Department();
        dept.setId(dto.getDepartment().getId());

        entity.setDepartment(dept);
        entity = repository.save(entity);
        return new PersonDepartmentDTO(entity);

    }

    // Sem aninhamento de classes (Person e Department)
    public PersonDTO2 insert(PersonDTO2 dto){

        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department dept = departmentRepository.getReferenceById(dto.getDepartmentId());
        // Department dept = new Department();
        // dept.setId(dto.getDepartmentId());

        entity.setDepartment(dept);
        entity = repository.save(entity);
        return new PersonDTO2(entity);

    }


    @Transactional(readOnly = true)
    public Page<PersonDTO> findAll(Pageable pageable) {
        Page<Person> result = repository.findAll(pageable);
        return result.map(x -> new PersonDTO(x));
    }
    
}
