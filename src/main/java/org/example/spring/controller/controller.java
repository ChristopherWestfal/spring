package org.example.spring.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class controller {

    List<Message> messageList = new ArrayList<>();

    @GetMapping("/hello")
    public String seyHello(){
        return "Hello";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloName(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @PostMapping("/message")
    public String addToMessageList(Message message){

        messageList.add(message);

        return "Messagelist size: " + messageList.size();
    }
    @GetMapping("/message")
    public List<Message> getMessageList(){

        addMesseges();

        return messageList;
    }

    @DeleteMapping("/message/id")
    public List<Message> deleteMessage(@RequestParam String id){
        int count = 0;
        addMesseges();

        for(Message m : messageList){

            if(m.getId().equals(id)) {
                messageList.remove(count);
            }
            count++;
        }

        return messageList;
    }

    private void addMesseges(){
        messageList.add(new Message("1. Nachricht", "Hey hey", "1"));
        messageList.add(new Message("2. Nachricht", "Hey hey", "2"));
        messageList.add(new Message("3. Nachricht", "Hey hey", "3"));
        messageList.add(new Message("4. Nachricht", "Hey hey", "4"));
    }
}
