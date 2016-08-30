package controllers.client;

import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Created by helix on 8/30/2016.
 */
public class RSAController extends Controller {
    String RSA1024 = "http://localhost:9999/rsa/5000/1024";
    String RSA512 = "http://localhost:9999/rsa/5000/512";
    String RSA2048 = "http://localhost:9999/rsa/5000/2048";
    @Inject
    WSClient ws;

    public CompletionStage<Result> RSA1024() {

        return ws.url(RSA1024).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }
    public CompletionStage<Result> RSA512() {

        return ws.url(RSA512).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }
    public CompletionStage<Result> RSA2048() {

        return ws.url(RSA2048).get()
                .thenApply(
                        response -> ok(response.getBody())
                );
    }
}
