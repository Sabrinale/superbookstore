package com.example.superbookstore.web;

import com.example.superbookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @RequestMapping(value= {"/", "/index"})
    public String BookList(Model model){
        // add attribute to html view
        model.addAttribute("books", repository.findAll());
        // render view html
        return "books";
    }

}
