package ru.acorn.CRUDapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.acorn.CRUDapp.dao.PersonDao;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;
    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String index(Model model){ //получаем всех людей в dao и передаем в представление
        model.addAttribute("people", personDao.index());
        return "people/index"; //папка и файл из webapp
    }
    @GetMapping("/{id}") //@PathVariable извлекает id из Url, т.е. в int id будель лежать число из url запроса
    public String show(@PathVariable("id") int id, Model model){
        //получаем одного человека из dao и передаем его на отображение во вью
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }
}
