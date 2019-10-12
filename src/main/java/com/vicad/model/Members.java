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

    public int getId() {
        return id;
    }

    public String getsName() {
        return sName;
    }

    public String getfName() {
        return fName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPostCode() {
        return postCode;
    }

    public List<Message> getMessageRecipient() {
        return messageRecipient;
    }

    public List<Message> getMessageSender() {
        return messageSender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setMessageRecipient(List<Message> messageRecipient) {
        this.messageRecipient = messageRecipient;
    }

    public void setMessageSender(List<Message> messageSender) {
        this.messageSender = messageSender;
    }
}
