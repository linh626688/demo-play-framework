package controllers.client;

import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Created by helix on 8/30/2016.
 */
public class TimeController extends Controller {
    String BIO = "http://localhost:9999/sleep/BIO";
    String NIO = "http://localhost:9999/sleep/NIO";
    @Inject
    WSClient ws;

    public CompletionStage<Result> sleepTime(Long time) {

        return ws.url(BIO + "/" + time).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }
    public CompletionStage<Result> sleepTimeAsync(Long time) {

        return ws.url(NIO + "/" + time).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }
}
