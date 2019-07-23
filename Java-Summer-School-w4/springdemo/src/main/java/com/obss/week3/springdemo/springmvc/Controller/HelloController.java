package com.obss.week3.springdemo.springmvc.Controller;

import com.obss.week3.springdemo.learningmanagementsystem.model.content.Content;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.ElearningContent;
import com.obss.week3.springdemo.springmvc.Error.ErrorMessage;
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
        contents.add(new ElearningContent(1L, "Furkan", "https://furkansuper.super", new Date(), new Date()));
        contents.add(new ElearningContent(2L, "Sena", "https://senagizli.vow", new Date(), new Date()));
        contents.add(new ElearningContent(3L, "Yunus", "https://yemreak.ak", new Date(), new Date()));
        contents.add(new ElearningContent(4L, "Silan", "https://silanerasmus.bilir", new Date(), new Date()));
    }

    // GET http://localhost:8080/hello
    @GetMapping
    public List<Content> getContents() {
        return contents;
    }

    // GET http://localhost:8080/hello/1
    @GetMapping("/{id}")
    public Content getContent(@PathVariable Long id) {
        return contents.stream().filter((content) -> id.equals(content.getId())).findFirst().orElse(null);
    }

    // GET http://localhost:8080/hello/search
    @GetMapping("/search")
    public List<Content> findContents(@RequestParam String name) {
        return contents.stream().filter((content) -> content.getName()
                .toLowerCase().contains(name)).collect(Collectors.toList());
    }

    // POST http://localhost:8080/hello/add-content
    @PostMapping("/add-content")
    public ResponseEntity<?> addContent(@RequestBody ElearningContent contentObj) {
        ErrorMessage errorMessage;
        if (contentObj.getId() == null || contentObj.getName() == null) {
            errorMessage = new ErrorMessage("Please fill required fields");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        Content existingContent = contents.stream()
                .filter((content) -> contentObj.getId().equals(content.getId()))
                .findFirst().orElse(null);

        if (existingContent != null) {
            errorMessage = new ErrorMessage("Please Enter Different id");
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        }

        contents.add(contentObj);

        return new ResponseEntity<>(contentObj, HttpStatus.OK);
    }
}
