package ru.acorn.CRUDapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.acorn.CRUDapp.dao.PersonDao;
import ru.acorn.CRUDapp.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String index(Model model) { //получаем всех людей в dao и передаем в представление
        model.addAttribute("people", personDao.index());
        return "people/index"; //папка и файл из webapp
    }

    @GetMapping("/{id}") //@PathVariable извлекает id из Url, т.е. в int id будель лежать число из url запроса
    public String show(@PathVariable("id") int id, Model model) {
        //получаем одного человека из dao и передаем его на отображение во вью
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }

    @GetMapping("/new") //запрос на форму создания человека
    public String newPerson(Model model) {  //в данном случае в модель будет передоваться все то, что мы занесли в форму
        model.addAttribute("person", new Person()); //т.е. создаем пустую заглушку
        return "people/new";     //можно все заменить на @ModelAttribute, спринг сам создаст пустой объект и положит его в модель
    }

    @PostMapping()      //в @ModelAttribute будет лежать Person с данными из формы
    public String create(@ModelAttribute("person") Person person) {
        personDao.save(person);
        return "redirect:/people";  //ключевое слово redirect перенаправляет на /people
    }

    @GetMapping("/{id}/edit") //находим по id человека, и затем нам нужно его поместить в модель
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDao.show(id));  //В модель мы кладем person, потому что view работаем через модель, а не dao
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person,
                         @PathVariable("id") int id) {
        personDao.update(id, person);  //id и человек, который пришел из формы
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id) {
        personDao.delete(id);
        return "redirect:/people";
    }


}


