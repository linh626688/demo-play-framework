package controllers;

import DTO.StudentDTO;
import com.avaje.ebean.Model;
import models.Student;
import org.apache.commons.lang3.RandomStringUtils;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by helix on 8/22/2016.
 */
public class StudentController extends Controller{
    public static java.util.List<Student> listStudent = new ArrayList<>();

    public static Model.Find<Long, Student> find = new Model.Find<Long, Student>() {
    };


    public static java.util.List<Student> findAll() {
        return find.all();
    }

    private StudentDTO createStudent() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        RandomStringUtils rd = new RandomStringUtils();
        Student student = new Student();
        student.setName(rd.random(1024, chars));
        listStudent.add(student);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        return studentDTO;
    }

    public Result getAll(int quantity) {
        for (int i = 0; i < quantity; i++) {
            createStudent();
        }
        List<StudentDTO> studentDTOs = new ArrayList<>();
        List<Student> studentList = (List<Student>) listStudent;
        for (Student student : studentList) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(student.getName());
            studentDTOs.add(studentDTO);
        }
        return ok(Json.toJson(studentDTOs));
    }
}
