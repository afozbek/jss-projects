package com.obss.week3.springdemo.springmvc.Controller;

import com.obss.week3.springdemo.learningmanagementsystem.model.content.Content;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.ElearningContent;
import com.obss.week3.springdemo.springmvc.Notifications.Messages.ErrorMessage;
import com.obss.week3.springdemo.springmvc.Notifications.Messages.InfoMessage;
import com.obss.week3.springdemo.springmvc.Notifications.Messages.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class HelloController {

    private List<Content> contents = new ArrayList<>();

    {
        contents.add(new ElearningContent(1L, "Furkan", "https://furkansuper.super", new Date(), new Date()));
        contents.add(new ElearningContent(2L, "Sena", "https://senagizli.vow", new Date(), new Date()));
        contents.add(new ElearningContent(3L, "Yunus", "https://yemreak.ak", new Date(), new Date()));
        contents.add(new ElearningContent(4L, "Silan", "https://silanerasmus.bilir", new Date(), new Date()));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Message> getIndex() {
        String message = "Welcome to Index Page 😊😊";
        Message infoMessage = new InfoMessage(message);
        return new ResponseEntity<Message>(infoMessage, HttpStatus.OK);
    }

    // GET http://localhost:8080/hello
    @GetMapping("/hello")
    public List<Content> getContents() {
        return contents;
    }

    // GET http://localhost:8080/hello/1
    @GetMapping("/hello/{id}")
    public Content getContent(@PathVariable Long id) {
        return contents.stream().filter((content) -> id.equals(content.getId())).findFirst().orElse(null);
    }

    // GET http://localhost:8080/hello/search
    @GetMapping("/hello/search")
    public List<Content> findContents(@RequestParam String name) {
        return contents.stream().filter((content) -> content.getName()
                .toLowerCase().contains(name)).collect(Collectors.toList());
    }

    // POST http://localhost:8080/hello/add-content
    @PostMapping("/hello/add-content")
    public ResponseEntity<?> addContent(@RequestBody ElearningContent contentObj) {
        Message message;

        if (contentObj.getId() == null || contentObj.getName() == null) {
            message = new ErrorMessage("Please fill required fields");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        // null or Content obj
        Content existingContent = contents.stream()
                .filter((content) -> contentObj.getId().equals(content.getId()))
                .findFirst()
                .orElse(null);

        // Content exist return error message
        if (existingContent != null) {
            message = new ErrorMessage("Please Enter Different id");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
        
        contents.add(contentObj);

        return new ResponseEntity<>(contentObj, HttpStatus.OK);
    }
}
