package com.vicad.model;


import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private int id;
    private String msgContent;



    @ManyToOne
    @JoinColumn(name = "recipient")
    private Members recipient;


    @ManyToOne
    @JoinColumn(name = "sender")
    private Members sender;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }
}













