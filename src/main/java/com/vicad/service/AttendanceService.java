package com.vicad.service;


import com.vicad.model.Attendance;
import com.vicad.model.Members;
import com.vicad.repository.AttendanceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {


    private AttendanceRepo attendanceRepo;

    public AttendanceService(AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }


    public Optional<Attendance> getOneAttendance(Integer id) {

        Optional<Attendance> attendance = attendanceRepo.findById(id);

        return attendance;
    }


    public List<Attendance> getAllAttendance() {

        List<Attendance> attendance = attendanceRepo.findAll();
        return attendance;
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }


    public void deleteRecord(Integer id) {

        attendanceRepo.deleteById(id);
    }


    public Boolean checkExistence(Integer id) {
        boolean result = attendanceRepo.existsById(id);
        return result;

    }

    public long countRecord() {

        long count = attendanceRepo.count();
        return count;
    }

}
