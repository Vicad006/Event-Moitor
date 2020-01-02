package com.vicad.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Members {

    @Id
    @GeneratedValue
    private int id;
    private String sName;
    private String fName;
    private String email;
    private String phoneNum;
    private String address;
    private Date birthday;
    private String postCode;


    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;


    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "maritalStatus_id")
    private MaritalStatus maritalStatus;

    @OneToMany(mappedBy = "recipient")
    private List<Message> messageRecipient;

    @OneToMany(mappedBy = "sender")
    private List<Message> messageSender;


    Members() {
    }

    public Members(String sName, String fName, String email, String phoneNum,
                   String address, Date birthday, String postCode, Department department,
                   Gender gender, MaritalStatus maritalStatus) {

        this.sName = sName;
        this.fName = fName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.birthday = birthday;
        this.postCode = postCode;
        this.department = department;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }


    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getDepartment() {
        return department.getId();
    }
}
