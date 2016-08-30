package controllers.client;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Created by helix on 8/26/2016.
 */
public class MyController extends Controller {
    String url = "http://localhost:9999/sayHello";
    String listURL = "http://localhost:9999/listtask";
    String urlAddTask = "http://localhost:9999/them";
    String urlDeleteTask = "http://localhost:9999/deleteTask";

    @Inject
    WSClient ws;

    public CompletionStage<Result> index() {

        return ws.url(url).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }

    public CompletionStage<Result> listTask(int n) {
        return ws.url(listURL + "/" + n).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }

    public CompletionStage<Result> addTask() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return (CompletionStage<Result>) badRequest("Expecting Json data");
        } else {
            String name = json.findPath("name").textValue();
            Boolean done = json.findPath("done").booleanValue();
            if (name == null) {
                return (CompletionStage<Result>) badRequest("Missing parameter [name]");
            } else {
                JsonNode jsonSent = Json.newObject()
                        .put("name", name)
                        .put("done", true);
                return ws.url(urlAddTask).setContentType("application/json").post(jsonSent).
                        thenApply(
                                response -> ok(response.getBody()));
            }
        }
    }

    public CompletionStage<Result> deleteTask(Long id) {
        return ws.url(urlDeleteTask + "/" + id).delete()
                .thenApply
                        (response -> ok("DELETE DONE"));
    }


}
