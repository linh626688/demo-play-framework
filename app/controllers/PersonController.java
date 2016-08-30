package controllers;

import DTO.PersonDTO;
import com.avaje.ebean.PagedList;
import models.Person;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static models.Person.findAll;

/**
 * Created by helix on 8/30/2016.
 */
public class PersonController extends Controller {

    final int PAGE_SIZE = 100;

    public Result getListPerson(int quantity) {
        List<PersonDTO> list = new ArrayList<>();
        List<Person> personList = (List<Person>) findAll();
        for (int i = 0; i < quantity; i++) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setName(personList.get(i).getName());
            personDTO.setSex(personList.get(i).getSex());
            personDTO.setAge(personList.get(i).getAge());
            personDTO.setBirthday(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            list.add(personDTO);
        }
        return ok(Json.toJson(list));
    }

    public Result getAll() {
        List<PersonDTO> list = new ArrayList<>();
        createPerson();
        List<Person> personList = (List<Person>) findAll();
        for (Person person : personList) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setName(person.getName());
            personDTO.setSex(person.getSex());
            personDTO.setAge(person.getAge());
            personDTO.setBirthday(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            list.add(personDTO);

        }
        return ok(Json.toJson(list));
    }


    private void createPerson() {
        for (int i = 1; i <= 400; i++) {
            Person person = new Person();
            person.setName("Jame" + i);
            person.setAge(30);
            person.setBirthday(new Date());
            person.setSex("male");
            person.save();
        }
    }

    public Result pageListPerson(int pageNumber) {
        PagedList<Person> listPerson = Person.page(pageNumber, PAGE_SIZE);
        List<PersonDTO> list = new ArrayList<>();
        for (Person person : listPerson.getList()) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setName(person.getName());
            personDTO.setSex(person.getSex());
            personDTO.setAge(person.getAge());
            personDTO.setBirthday(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            list.add(personDTO);
        }
        return ok(Json.toJson(list));
    }


}
