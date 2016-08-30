package controllers.client;

import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Created by helix on 8/30/2016.
 */
public class StringController extends Controller {

    String word = "http://localhost:9999/ram";
    String file = "http://localhost:9999/disk/5000/1024";

    @Inject
    WSClient ws;

    public CompletionStage<Result> createRamdomWords(int quantity, int length) {

        return ws.url(word + "/" + quantity + "/" + length).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }

    public CompletionStage<Result> createRandomFile() {

        return ws.url(file).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }
}
