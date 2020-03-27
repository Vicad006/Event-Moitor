package com.vicad.controller;


import com.vicad.model.Attendance;
import com.vicad.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class AttendanceController {

    private AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }



    @GetMapping("/attendance")
    public List<Attendance> getAllAttendance(){
        List<Attendance> attendance = attendanceService.getAllAttendance();
        return attendance;

    }


    @PostMapping("/attendance")
    public ResponseEntity<Object> createAttendance(@RequestBody Attendance attendance){
        Attendance attendance1 = attendanceService.createAttendance(attendance);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(attendance.getId()).toUri();

           return ResponseEntity.created(location).build();
    }

    @GetMapping("/attendance/{id}")
    public ResponseEntity<Object> getOneAttendance(@PathVariable Integer id){

        Optional<Attendance> attendance = attendanceService.getOneAttendance(id);
        if (!attendance.isPresent())
            return new ResponseEntity<>("Member " +id + " not found" , HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(attendance.get(), HttpStatus.OK);


    }

    @PutMapping("/attendance/{id}")
    public ResponseEntity<Object> updateAttendance(@RequestBody Attendance attendance, @PathVariable Integer id){

        if(!attendanceService.checkExistence(id))
            return new ResponseEntity<>("Attendace of " +id+ "not found ", HttpStatus.NOT_FOUND );

            attendance.setId(id);
            attendanceService.createAttendance(attendance);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("attendance/{id}")
    public void removeAttendance(@PathVariable Integer id){

        attendanceService.deleteRecord(id);
    }

}
