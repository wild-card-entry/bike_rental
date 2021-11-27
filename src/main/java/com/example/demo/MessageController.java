package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/message")
public class MessageController {
    @Autowired
    private MessageRepository messagerepository;
    @GetMapping(path="/all")
    public @ResponseBody Iterable <Message > getAllMessages()
    {
       return messagerepository.findAll();
    }
    @GetMapping(path="/personalised")
    public @ResponseBody Iterable <Message> getPeronalisedMessages()
    {
        return messagerepository.findAllByUserId(2);
    }
    @PostMapping(path="/add")
    public @ResponseBody String addMessages(@RequestParam String content, @RequestParam Integer user_id )
    {
        Message m= new Message();
        m.setContent(content);
        messagerepository.save(m);
        return "Saved";


    }

}
