package controllers.client;

import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Created by helix on 8/30/2016.
 */
public class NetioController extends Controller {
    String url = "http://localhost:9999/netio";
    @Inject
    WSClient ws;

    public CompletionStage<Result> getString(int length) {
        return ws.url(url + "/" + length).get()
                .thenApply(response -> ok(response.getBody())
                );

    }
}
