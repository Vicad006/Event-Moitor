package com.vicad.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Gender {

    @Id
    @GeneratedValue
    private int id;
    private String details;




    @OneToMany(mappedBy = "gender")
    private List <Members> members;


    Gender (){

    }

    public Gender(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setMembers(List<Members> members) {
        this.members = members;
    }
}
