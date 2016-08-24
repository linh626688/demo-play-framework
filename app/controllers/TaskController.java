package controllers;

import com.avaje.ebean.Model;
import models.Task;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Created by helix on 8/20/2016.
 */
public class TaskController extends Controller {

    public static Model.Find<Long, Task> find = new Model.Find<Long, Task>() {
    };

    public static java.util.List<Task> findAll() {
        return find.all();
    }

    private WSClient ws;

    @Inject
    public TaskController(WSClient ws) {
        this.ws = ws;
    }

//    public CompletionStage<Result> homeTimeline() {
//        Optional<RequestToken> sessionTokenPair = getSessionTokenPair();
//        if (sessionTokenPair.isPresent()) {
//            return ws.url("https://api.twitter.com/1.1/statuses/home_timeline.json")
//                    .sign(new OAuthCalculator(Twitter.KEY, sessionTokenPair.get()))
//                    .get()
//                    .thenApply(result -> ok(result.asJson()));
//        }
//        return CompletableFuture.completedFuture(redirect(routes.Twitter.auth()));
//    }

    public Result addTask() {
        Task task = new Task();
        task.setId("111");
        task.setContents("LOL");
        task.save();
        return ok("LOL");
    }

    public Result getTask() {
        java.util.List<Task> people = findAll();
        return ok(Json.toJson(people));
    }

    public Result Hello(int name) {
        return ok("hello" + name);
    }


}
