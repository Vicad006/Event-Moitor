package com.vicad.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Attendance {

    @Id
    @GeneratedValue
    private  int id;
    private Date regDate;
    private String attendance;
    private int userId;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Members members;


    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;


    public Attendance(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
