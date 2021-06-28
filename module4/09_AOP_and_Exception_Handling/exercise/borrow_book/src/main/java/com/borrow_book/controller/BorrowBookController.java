package com.borrow_book.controller;

import com.borrow_book.model.entity.Book;
import com.borrow_book.model.entity.LibraryCard;
import com.borrow_book.model.entity.dto.LibraryCardDto;
import com.borrow_book.model.service.IBookService;
import com.borrow_book.model.service.ILibraryCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class BorrowBookController {
    private final IBookService bookService;
    private final ILibraryCardService libraryCardService;

    public BorrowBookController(IBookService bookService, ILibraryCardService libraryCardService) {
        this.bookService = bookService;
        this.libraryCardService = libraryCardService;
    }

    @ModelAttribute("books")
    public Iterable<Book> listBook() {
        return bookService.findAll();
    }

    @GetMapping(path = "")
    public String showLibrary() {
        return "index";
    }

    @GetMapping(path = "/save")
    public String save(@ModelAttribute("libraryCardDto") LibraryCardDto libraryCardDto, @RequestParam("id") Integer id) throws Exception {
            Book book = bookService.findById(id).orElse(new Book());
            libraryCardDto.setBook(book);
            if(book.getAmount()==0){
                throw new Exception("The book has been borrowed");
            }
            libraryCardDto.setId((int) (Math.random() * (99999 - 10000)) + 10000);
            libraryCardDto.setBorrowedDate(LocalDate.now());
            LibraryCard libraryCard = new LibraryCard();
            BeanUtils.copyProperties(libraryCardDto, libraryCard);

            book.setAmount(book.getAmount() - 1);
            bookService.save(book);
            libraryCardService.save(libraryCard);

        return "redirect:/";
    }

    @GetMapping(path = "/rent/{id}")
    public ModelAndView showBook(@PathVariable("id") Integer id) throws Exception {
            return new ModelAndView("book-rental", "libraryCardDto", new LibraryCardDto()).addObject("book", bookService.findById(id).orElse(new Book()));

    }

    @GetMapping(path = "/return")
    public ModelAndView showFormReturn(@RequestParam(name = "id", required = false) Integer id) {

        return new ModelAndView("return-book", "id", id);
    }

    @PostMapping(path = "/return")
    public String returnedBook(@RequestParam(name = "id", required = false) Integer id) throws Exception {
        LibraryCard libraryCard  = libraryCardService.findById(id).orElse(new LibraryCard());

            if (libraryCard.getStatus() == null) {
                libraryCard.setReturnedDate(LocalDate.now());
                libraryCard.setStatus("done");
                Book book = libraryCard.getBook();
                book.setAmount(book.getAmount() + 1);
                libraryCardService.save(libraryCard);
                bookService.save(book);
            }else{
                throw new Exception("This card is already in use");
            }

        return "redirect:/";
    }
    @ExceptionHandler(Exception.class)
    public String handleException(RedirectAttributes redirectAttributes,Exception e){
        redirectAttributes.addFlashAttribute("message",e.getMessage());
        return "redirect:/";
    }
}
