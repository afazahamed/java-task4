package com.library.libraryapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookListController {

    @Autowired
    private BookListRepository bookListRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getBookListByAuthor(Model model){

        model.addAttribute("allBooks", bookListRepository.findAll());
        return "booksList";
    }

    @PostMapping("/add")
    public String addBook(BookListModel bookListModel) {

        List<BookListModel> BookListArray = new ArrayList<BookListModel>();

        BookListArray.add(bookListModel);

        bookListRepository.saveAll(BookListArray);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String getId(@RequestParam int id) {
        System.out.println(id);
        return "redirect:/";
    }


}
