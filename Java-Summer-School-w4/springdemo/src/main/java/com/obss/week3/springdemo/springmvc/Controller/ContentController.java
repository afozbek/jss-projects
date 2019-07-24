package com.obss.week3.springdemo.springmvc.Controller;

import com.obss.week3.springdemo.learningmanagementsystem.model.content.Content;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.ElearningContent;
import com.obss.week3.springdemo.springmvc.DAO.ContentRepository;
import com.obss.week3.springdemo.springmvc.Notifications.Messages.ErrorMessage;
import com.obss.week3.springdemo.springmvc.Notifications.Messages.InfoMessage;
import com.obss.week3.springdemo.springmvc.Notifications.Messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentRepository contentRepository;

    // GET http://localhost:8080/content ✔
    @GetMapping
    public ResponseEntity<?> getContents(@RequestParam(required = false, name = "name") String name,
                                         @RequestParam(required = false, name = "ratio") Double ratio) {
        List<ElearningContent> filteredContents;

        if (name != null && ratio != null) {
            filteredContents = contentRepository.findByNameAndSuccessRatio(name, ratio);
        } else if (name != null) {
            filteredContents = contentRepository.findByName(name);
        } else if (ratio != null) {
            filteredContents = contentRepository.findBySuccessRatio(ratio);
        } else {
            filteredContents = contentRepository.findAll();
        }

        return new ResponseEntity<>(filteredContents, HttpStatus.OK);
    }

    // POST http://localhost:8080/content ✔
    @PostMapping
    public ResponseEntity<?> addContent(@RequestBody ElearningContent contentObj) {
        Message message;

        if (contentObj.getName() == null) {
            message = new ErrorMessage("Please fill required fields");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        // Add to database
        contentRepository.save(contentObj);

        return new ResponseEntity<>(contentObj, HttpStatus.OK);
    }

    // GET http://localhost:8080/content/1 ✔
    @GetMapping("/{id}")
    public Content getContent(@PathVariable Long id) {
        Content content = contentRepository.findById(id).get();

        return content;

//        return contents
//                .stream()
//                .filter((content) -> id.equals(content.getId()))
//                .findFirst()
//                .orElse(null);
    }

    // PUT http://localhost:8080/content/1 ✔
    @PutMapping("/{id}")
    public ResponseEntity<?> getContent(@PathVariable Long id, @RequestBody ElearningContent contentObj) {
        Message message;

        ElearningContent content = contentRepository.findById(id).orElse(null);

        if (content == null) {
            message = new ErrorMessage("Content was not found");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            message = new InfoMessage("Content succesfully updated");
            content.setName(contentObj.getName());
            content.setUrl(contentObj.getUrl());

            contentRepository.save(content);

            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    // DELETE http://localhost:8080/content/1 ✔
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContent(@PathVariable Long id) {
        Message message;
        ElearningContent content = contentRepository.findById(id).orElse(null);

        if (content == null) {
            message = new ErrorMessage("Content not found");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            contentRepository.delete(content);
        }
        message = new InfoMessage("Successfully deleted");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // GET http://localhost:8080/content/search ✔
    @GetMapping("/search")
    public ResponseEntity<?> findContents(@RequestParam(required = false, name = "name") String name) {
        if (name == null) {
            return new ResponseEntity<>(new ErrorMessage("You must specify name value"), HttpStatus.BAD_REQUEST);
        }

        List<ElearningContent> content = contentRepository.findByName(name);

        if (content == null) {
            return new ResponseEntity<>(new InfoMessage("Your content was not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(content, HttpStatus.OK);
    }
}
