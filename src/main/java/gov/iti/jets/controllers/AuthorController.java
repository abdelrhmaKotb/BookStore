package gov.iti.jets.controllers;

import gov.iti.jets.services.AuthorService;
import gov.iti.jets.services.BookService;
import gov.iti.jets.services.dto.AuthorDto;
import gov.iti.jets.services.dto.BookDto;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("authors")
public class AuthorController {
    AuthorService authorService;
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("author", new AuthorDto());
        return "author/create";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("author") AuthorDto authorDto, BindingResult result,Model model){
        if(result.hasErrors()){
            return "author/create";
        }

        try {
            authorService.save(authorDto);
        } catch (Exception e) {
            //add some errors here
            throw new RuntimeException(e);
        }

        return "redirect:/authors/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<AuthorDto> authors = new ArrayList<>();
        try {
            authors = authorService.getAll();
            System.out.println("authors " + authors);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("authors",authors);
        return "author/list";
    }

//    @RequestMapping(value = "/remove",method = RequestMethod.POST)
//    public String list(@RequestParam("id") int id){
//        System.out.println(id);
//        try {
//            BookDto bookDto = new BookDto();
//            bookDto.setId(id);
//            bookService.remove(bookDto);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return "redirect:list";
//    }
//
//
//    @RequestMapping(value = "/{id}/edit",method = RequestMethod.GET)
//    public String edit(@PathVariable("id") int id, Model model){
//        BookDto bookDto = null;
//        List<AuthorDto> authors = new ArrayList<>();
//        try {
//            bookDto = bookService.get(id);
//            if(bookDto == null){
//                return "redirect:/books/list";
//            }
//            authors =  authorService.getAll();
//        }catch (Exception e){
//            e.printStackTrace();
//            return "redirect:/books/list";
//        }
//        model.addAttribute("authors",authors);
//        model.addAttribute("book",bookDto);
//        return "book/edit";
//    }
//
//
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public String update(@Valid @ModelAttribute("book") BookDto bookDto,BindingResult result){
//        if(result.hasErrors()){
//            return "book/edit";
//        }
//        try {
//            bookService.update(bookDto);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return "redirect:/books/list";
//    }

}
