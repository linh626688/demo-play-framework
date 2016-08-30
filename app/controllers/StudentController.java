package controllers;

import DTO.StudentDTO;
import models.Student;
import org.apache.commons.lang3.RandomStringUtils;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

import static models.Student.find;

/**
 * Created by helix on 8/22/2016.
 */
public class StudentController extends Controller {


    private StudentDTO createStudent() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        RandomStringUtils rd = new RandomStringUtils();
        Student student = new Student();
        student.setName(rd.random(1024, chars));
        student.save();

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        return studentDTO;
    }

    public Result getListStudent(int quantity) {
        for (int i = 0; i < quantity; i++) {
            createStudent();
        }
        List<StudentDTO> studentDTOs = new ArrayList<>();
        List<Student> studentList = (List<Student>) find.all();
        for (Student student : studentList) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(student.getName());
            studentDTOs.add(studentDTO);
        }
        return ok(Json.toJson(studentDTOs));
    }
}
