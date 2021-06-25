package com.codegym.controller.restful;

import com.codegym.model.BlogWeb;
import com.codegym.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogControllerRESTful {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Iterable<BlogWeb>> showBlogForm(){
        List<BlogWeb> blogWebs = (List<BlogWeb>) blogService.findAll();
        if(blogWebs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogWebs, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<BlogWeb> createBlog(@RequestBody BlogWeb blogWeb){
        return new ResponseEntity<>(blogService.save(blogWeb), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<BlogWeb> editBlog(@PathVariable Long id, @RequestBody BlogWeb blogWeb){
        Optional<BlogWeb> blogWebOptional = blogService.findById(id);
        if (!blogWebOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogWeb.setId(blogWebOptional.get().getId());
        return new ResponseEntity<>(blogService.save(blogWeb), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BlogWeb> delete(@PathVariable Long id){
        Optional<BlogWeb> blogWebOptional = blogService.findById(id);
        if (!blogWebOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blogWebOptional.get(), HttpStatus.NO_CONTENT);
    }

}
