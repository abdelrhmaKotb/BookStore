package gov.iti.jets.controllers;

import gov.iti.jets.models.Book;
import gov.iti.jets.repositories.AuthorRepository;
import gov.iti.jets.repositories.BookRepository;
import gov.iti.jets.services.AuthorService;
import gov.iti.jets.services.BookService;
import gov.iti.jets.services.dto.AuthorDto;
import gov.iti.jets.services.dto.BookDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {
    AuthorService authorService;
    BookService bookService;
    public BookController(AuthorService authorService,BookService bookService){
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("book") BookDto bookDto){
        ModelAndView modelAndView = new ModelAndView("book/create");

        List<AuthorDto> authors = new ArrayList<>();
        try {
             authors =  authorService.getAll();
        } catch (Exception e) {
            modelAndView.addObject("errors", "there are some errors");
            e.printStackTrace();
        }

        modelAndView.addObject("authors",authors);

        System.out.println(authors);
        return modelAndView;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") BookDto bookDto, BindingResult result,Model model){
        if(result.hasErrors()){
            System.out.println("errr");
            System.out.println(result);
            List<AuthorDto> authors = new ArrayList<>();
            try {
                authors =  authorService.getAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("authors",authors);
            return "book/create";
        }

        try {
            bookService.save(bookDto);
        } catch (Exception e) {
            //add some errors here
            throw new RuntimeException(e);
        }

        return "redirect:/books/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<BookDto> books = new ArrayList<>();
        try {
            books = bookService.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("books",books);
        return "book/list";
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public String list(@RequestParam("id") int id){
        System.out.println(id);
        try {
            BookDto bookDto = new BookDto();
            bookDto.setId(id);
            bookService.remove(bookDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:list";
    }


    @RequestMapping(value = "/{id}/edit",method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model){
        BookDto bookDto = null;
        List<AuthorDto> authors = new ArrayList<>();
        try {
            bookDto = bookService.get(id);
            if(bookDto == null){
                return "redirect:/books/list";
            }
            authors =  authorService.getAll();
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/books/list";
        }
        model.addAttribute("authors",authors);
        model.addAttribute("book",bookDto);
        return "book/edit";
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("book") BookDto bookDto,BindingResult result){
        if(result.hasErrors()){
            return "book/edit";
        }
        try {
            bookService.update(bookDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/books/list";
    }

}
