package controllers.client;

import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Created by helix on 8/30/2016.
 */
public class PersonController extends Controller {
    String list = "http://localhost:9999/json";
    String all = "http://localhost:9999/db-json/all";
    String page = "http://localhost:9999/db-json";

    @Inject
    WSClient ws;

    public CompletionStage<Result> getListPerson(int quantity) {
        return ws.url(list + "/" + quantity).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }

    public CompletionStage<Result> getAll() {

        return ws.url(all).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }

    public CompletionStage<Result> pageListPerson(int pageNumber) {

        return ws.url(page + "/" + pageNumber + "/" + 100).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }

}

