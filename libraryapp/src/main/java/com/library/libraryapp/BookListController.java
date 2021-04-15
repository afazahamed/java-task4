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

//    @GetMapping("/delete/{id}")
//    @ResponseBody
//    public String getId(@RequestParam int id) {
////        bookListRepository.removeIf()
////        return "ID: " + id;
//
////        int id2=Integer.parseInt(id);
//
//        bookListRepository.deleteById(id);
//
//        return "redirect:/";
//    }

//    @DeleteMapping(value = "/delete/{id}")
//    @DeleteMapping("/delete/{id}")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public String deleteBook(@PathVariable int id){
        bookListRepository.deleteAll();
//        db.BookListModel.remove({"id" :  {id})
//        db.users.remove({"email" :  { id : id}});
//        System.out.println(id);
//        db.collection("bookListModel").deleteOne({_id:ObjectId(id)});
//        db.bookListRepository.deleteOne( {"_id": ObjectId(id)});
        return "redirect:/";
    }

}
