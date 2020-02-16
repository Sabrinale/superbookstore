package com.example.superbookstore.web;

import com.example.superbookstore.domain.Book;
import com.example.superbookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @RequestMapping(value= {"/"})
    public String BookList(Model model){
        // add attribute to html view
        model.addAttribute("books", repository.findAll());
        // render view html
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addStudent(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String editsSave(@ModelAttribute(value="book") Book book, @PathVariable("id") Long bookId ){
        book.setId(bookId);
        repository.save(book);
        return "redirect:../";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long studentId, Model model) {
        repository.deleteById(studentId);
        return "redirect:../";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Book foo = repository.findById(id).orElse(null);
        model.addAttribute("book", foo);
       /* Optional<Book> foo = repository.findById(id);
        model.addAttribute("book", repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id)));*/

        return "editbook";
    }
}
