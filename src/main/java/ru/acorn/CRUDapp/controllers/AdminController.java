package ru.acorn.CRUDapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.acorn.CRUDapp.dao.PersonDAO;
import ru.acorn.CRUDapp.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PersonDAO personDAO;
    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()//@ModelAttribute создает путой объект Person со всеми его незаполненными полями
    public String adminPage(Model model, @ModelAttribute("person") Person person){
        model.addAttribute("people", personDAO.index());//в модель кладем список из людей, потому что это список будем использовать в выпадающем списке
        return "adminPage";
    }
    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") Person person){
        return "redirect:/people";
    }
}
