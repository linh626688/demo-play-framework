package controllers;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Task;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;

/**
 * Created by helix on 8/20/2016.
 */
public class TaskController extends Controller {


    public static Model.Find<Long, Task> find = new Model.Find<Long, Task>() {
    };

    public static java.util.List<Task> findAll() {
        return find.all();
    }

    public TaskController() {
    }

    public Result addTask() {
        Task task = new Task();
        task.setName("LOL");
        task.setId(20);
        task.save();
        return ok(Json.toJson(task.getName() + "" + task.getId()));
    }

    public Result listTask(Long n) {
        ArrayList<Task> arr = new ArrayList<>();
        for (Long i = 1L; i < n; i++) {
            if (Task.find.byId(i).getId() < n) {
                arr.add(Task.find.byId(i));
            }
        }
        return ok(Json.toJson(arr));

//        for (int i = 2; i < n; i++) {
//            Task task = new Task();
//            task.setId(i);
//            task.setName("Helix");
//            task.setDone(true);
//            task.save();
//        }
//        return ok();
    }

    //    public Result sayHello() {
//        JsonNode json = request().body().asJson();
//        if (json == null) {
//            return badRequest("Expecting Json data");
//        } else {
//            String name = json.findPath("name").textValue();
//            if (name == null) {
//                return badRequest("Missing parameter [name]");
//            } else {
//                return ok(Json.toJson("Hello " + name));
//            }
//        }
//    }

    public Result them() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting Json data");
        } else {
            String name = json.findPath("name").textValue();
            Boolean done = json.findPath("done").booleanValue();
            if (name == null) {
                return badRequest("Missing parameter [name]");
            } else {
                Task task = new Task();
                task.setName(name);
                task.setDone(done);
                task.save();
                return ok(Json.toJson(task));
            }
        }
    }

    public Result sayHello() {
        ObjectNode result = Json.newObject();
        result.put("exampleField1", "foobar");
        result.put("exampleField2", "Hello world!");
        return ok(result);
    }

    public Result getTask() {
        java.util.List<Task> people = findAll();
        return ok(Json.toJson(people));
    }

    public Result Hello(int name) {
        return ok("hello" + name);
    }


    //    @Transactional
    public Result done(long id) {
        Task task = Task.find.byId(id);
//        task.setName("Change");
        task.delete();
        return ok();
    }

    public Result jsonResult(Result httpResponse) {
        response().setContentType("application/json; charset=utf-8");
        return httpResponse;
    }

    public Result themTask() {
        Form<Task> taskForm = Form.form(Task.class);

        Form<Task> task = taskForm.bindFromRequest();

        if (task.hasErrors()) {
            return jsonResult(badRequest(task.errorsAsJson()));
        }

        Task newTask = new Task();
        newTask.setName(task.get().getName());

        newTask.save();

        return ok(Json.toJson(newTask).toString());
    }

    public Result deleteTask(Long id) {
        Task task = Task.find.byId(id);
        task.delete();
        return ok("DELETE DONE");

    }
}
