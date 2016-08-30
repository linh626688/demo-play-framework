package controllers.client;

import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Created by helix on 8/30/2016.
 */
public class StudentController extends Controller {
    String url = "http://localhost:9999/db";
    @Inject
    WSClient ws;

    public CompletionStage<Result> getListStudent(int quantity) {

        return ws.url(url + "/" + quantity).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }
}
