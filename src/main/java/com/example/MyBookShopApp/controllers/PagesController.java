package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.AuthorService;
import com.example.MyBookShopApp.data.BookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookshop")
public class PagesController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final Logger logger = Logger.getLogger(BookService.class);

    @Autowired
    public PagesController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        logger.info("Got main page");
        model.addAttribute("bookData", bookService.getBooksData());
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage() {
        logger.info("Got genres page");
        return "genres/index";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        logger.info("Got authors page");
        model.addAttribute("authorData", authorService.getAuthorsData());
        return "authors/index";
    }
}
