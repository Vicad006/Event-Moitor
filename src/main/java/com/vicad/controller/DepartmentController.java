package com.vicad.controller;


import com.vicad.model.Department;
import com.vicad.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
public class DepartmentController {

   private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/department")
    public List<Department> getAll(){
        List<Department> departments = departmentService.getAllDepartment();
        return departments;
    }


    @PostMapping("/department")
    public ResponseEntity<Object> createDepartment(@RequestBody Department department){

        Department department1 = departmentService.createDepartment(department);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(department1.getId()).toUri();

        return ResponseEntity.created(location).build();

    }


    @GetMapping("/department/{id}")
    public ResponseEntity<Object> getOneDepartment(@PathVariable Integer id){

        Optional<Department> department = departmentService.getOneDepartment(id);

        if (!department.isPresent())

            return new ResponseEntity<>("Department "+id+" Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(department.get(), HttpStatus.OK);


    }


    @PutMapping("/department/{id}")
    public ResponseEntity<Object> updateDepartment(@RequestBody Department department, @PathVariable Integer id){

        if (!departmentService.checkExistence(id))
            return new ResponseEntity<>("Module "+id+" Not Found",
                    HttpStatus.NOT_FOUND);

        department.setId(id);
        departmentService.createDepartment(department);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/department/{id}")
    public void removeDepartment(@PathVariable Integer id) {
        departmentService.deleteRecord(id);
    }




}
