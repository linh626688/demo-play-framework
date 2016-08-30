package controllers;

import org.apache.commons.lang3.time.StopWatch;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by helix on 8/22/2016.
 */
public class TimeController extends Controller {
    public Result sleepTime(Long time) throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        Thread.sleep(time);
        System.out.println("... " + time / 1000 + " seconds after");
        sw.stop();
        System.out.println(Thread.currentThread().getName() + " - BIO: " + sw.getTime() / 1000L + " seconds");

        return ok("done");
    }

    public Result sleepTimeAsync(Long time) {
        StopWatch sw = new StopWatch();
        sw.start();
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture.runAsync(() -> {
            try {
                sleepTime(time);

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }

        }, executorService);
        sw.stop();
        System.out.println(Thread.currentThread().getName() + " - NIO: " + sw.getTime() / 1000L + " seconds");

        return ok("ok");
    }
}
