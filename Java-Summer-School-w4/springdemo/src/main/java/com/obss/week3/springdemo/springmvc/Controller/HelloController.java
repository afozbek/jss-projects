package com.obss.week3.springdemo.springmvc.Controller;

import com.obss.week3.springdemo.learningmanagementsystem.model.content.Content;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.ElearningContent;
import com.obss.week3.springdemo.springmvc.ResponseMessage.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private List<Content> contents = new ArrayList<>();

    {
        contents.add(new ElearningContent(1L, "Furkan", "furkansuper.com", new Date(), new Date()));
        contents.add(new ElearningContent(2L, "Bilgehan", "bilgehan.com", new Date(), new Date()));
    }

    @GetMapping
    public List<Content> getContents() {
        return contents;
    }

    @GetMapping("/{id}")
    public Content getContent(@PathVariable Long id) {
        return contents.stream().filter((content) -> id.equals(content.getId())).findFirst().orElse(null);
    }

    @GetMapping("/search")
    public List<Content> findContents(@RequestParam String name) {
        return contents.stream().filter((content) -> content.getName()
                .toLowerCase().contains(name)).collect(Collectors.toList());
    }

    @PostMapping("/add-content")
    public ResponseEntity<?> addContent(@RequestBody ElearningContent contentObj) {
        ResponseMessage responseMessage;
        if (contentObj.getId() == null || contentObj.getName() == null) {
            responseMessage = new ResponseMessage("Please fill required fields");
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }

        Content existingContent = contents.stream()
                .filter((content) -> contentObj.getId().equals(content.getId()))
                .findFirst().orElse(null);

        if (existingContent != null) {
            responseMessage = new ResponseMessage("Please Enter Different id");
            return new ResponseEntity<>(responseMessage, HttpStatus.CONFLICT);
        }

        contents.add(contentObj);

        return new ResponseEntity<>(contentObj, HttpStatus.OK);
    }
}
