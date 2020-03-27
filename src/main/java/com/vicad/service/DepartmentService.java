package com.vicad.service;


import com.vicad.model.Department;
import com.vicad.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }


    public Optional <Department> getOneDepartment(Integer id){


    Optional<Department> department = departmentRepo.findById(id);


        return  department;

    }

    public List<Department> getAllDepartment(){

        List<Department> departments = departmentRepo.findAll();
        return  departments;
    }


    public Department createDepartment(Department department){

        return departmentRepo.save(department);

    }

    public void deleteRecord(Integer id){

        departmentRepo.deleteById(id);

    }


    public Boolean checkExistence(Integer id){

        boolean result = departmentRepo.existsById(id);

        return result;
    }


    public long countRecord(){

        long count = departmentRepo.count();
        return count;
    }

}
