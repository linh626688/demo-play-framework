package controllers;

import DTO.PersonDTO;
import models.Person;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by helix on 8/22/2016.
 */
public class PersonController extends Controller {
    final int PAGE_SIZE = 100;


    public static java.util.List<Person> listPerson = new ArrayList<>();


    public Result getListPerson(int quantity) {
        List<PersonDTO> list = new ArrayList<>();
        PersonDTO personDTO = new PersonDTO();
        personDTO.setAge(150);
        personDTO.setBirthday(new SimpleDateFormat("dd-mm-yyyy").format(new Date(3)));
        personDTO.setName("James Bone");
        personDTO.setSex("male");

        for (int i = 0; i < quantity; i++) {
            list.add(personDTO);
        }


        return ok(Json.toJson(list));
    }

    public Result getUserWithPage(int pageNumber) {
        return null;
    }


    public Result getAll() {
        List<PersonDTO> list = new ArrayList<>();
        createPerson();

        List<Person> personList = (List<Person>) listPerson;
        for (Person person : personList) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setName(person.getName());
            personDTO.setSex(person.getSex());
            personDTO.setAge(person.getAge());
            personDTO.setBirthday(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            list.add(personDTO);
        }

        return ok(personList.size() + " " + list.size());

    }

    private void createPerson() {
        for (int i = 1; i <= 400; i++) {
            Person person = new Person();
            person.setName("Jame" + i);
            person.setAge(30);
            person.setBirthday(new Date());
            person.setSex("male");
            listPerson.add(person);
        }
    }

    public Result sayHello(String name) {
        return ok("hello " + name);
    }


//    public Result getPersonWithPage(int pageNumber) {
//        List<PersonDTO> list = new ArrayList<>();
//
//        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
//        Page<Person> personPage = (Page<Person>) findAll();
//        List<Person> personList = personPage.getContent();
//
//        List<PersonDTO> personDTOs = new ArrayList<>();
//        PersonDTO personDTO = new PersonDTO();
//
//        for (int i = 0; i < personList.size(); i++) {
//            personDTO.setName(personList.get(i).getName());
//            personDTO.setAge(personList.get(i).getAge());
//            personDTO.setSex(personList.get(i).getSex());
//            personDTO.setBirthday(new SimpleDateFormat("dd-mm-yyyy").format(personList.get(i).getBirthday()));
//            personDTOs.add(personDTO);
//        }
//
//        PageDTO pageDTO = new PageDTO();
//        pageDTO.setPersonList(personDTOs);
//        pageDTO.setTotalPage(personPage.getTotalPages());
//        pageDTO.setNumberOfElements(personPage.getNumberOfElements());
//        pageDTO.setPageCurrent(personPage.getNumber() + 1);
//        pageDTO.setSize(personPage.getSize());
//        pageDTO.setTotalElements(personPage.getTotalElements());
//
//        return ok(Json.toJson(pageDTO));
//    }
}
