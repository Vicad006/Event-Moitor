package com.vicad.service;

import com.vicad.model.Message;
import com.vicad.repository.MessageRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private MessageRepo messageRepo;

    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    public Optional<Message> getOneMessages(Integer id){

        Optional<Message> message = messageRepo.findById(id);
        return message;
    }

    public List<Message> getAllMessages(){

        List<Message> messages = messageRepo.findAll();
        return  messages;

    }

    public Message createMessage(Message message){

        return messageRepo.save(message);
    }

    public Boolean checkExistence(Integer id){
        boolean result = messageRepo.existsById(id);
        return result;
    }

    public void deleteRecord(Integer id){
        messageRepo.deleteById(id);

    }

    public long countRecord(){
        long count = messageRepo.count();
        return count;
    }
}
