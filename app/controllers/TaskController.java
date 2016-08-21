package controllers;

import models.Task;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by helix on 8/20/2016.
 */
public class TaskController extends Controller {


    public Result addTask() {
        Task task = new Task();
        task.setId("111");
        task.setContents("LOL");
        task.save();
        return ok("LOL");
    }

    public Result getTask() {
        java.util.List<Task> people = Task.findAll();
        return ok(Json.toJson(people));
    }

}
