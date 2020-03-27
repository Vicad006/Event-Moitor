package com.vicad.controller;

import com.vicad.model.Gender;
import com.vicad.model.MaritalStatus;
import com.vicad.model.Message;
import com.vicad.repository.GenderRepo;
import com.vicad.repository.MaritalStatusRepo;
import com.vicad.repository.MessageRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
//@RequestMapping("/api/v1")
public class MessageController {

    private MessageRepo messageRepo;
    private MaritalStatusRepo maritalStatusRepo;
    private GenderRepo genderRepo;

    public MessageController(MessageRepo messageRepo,
                             MaritalStatusRepo maritalStatusRepo,
                             GenderRepo genderRepo) {
        this.messageRepo = messageRepo;
        this.maritalStatusRepo = maritalStatusRepo;
        this.genderRepo = genderRepo;
    }

    @GetMapping("/message")
    public List <Message> getAllMessages(){

        List<Message> message = messageRepo.findAll();
        return message;

    }

    @GetMapping("/gender")
    public List<Gender> getAllGender() {

        List<Gender> gender = genderRepo.findAll();
        return gender;
    }

    @GetMapping("/status")
    public List<MaritalStatus> getAllMaritalStatus() {

        List<MaritalStatus> maritalStatuses = maritalStatusRepo.findAll();
        return maritalStatuses;
    }





}
