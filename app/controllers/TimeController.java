package controllers;

import play.mvc.Result;

import static play.mvc.Results.ok;

/**
 * Created by helix on 8/22/2016.
 */
public class TimeController {
    public Result sleepTime(Long time) throws InterruptedException {
        Thread.sleep(time);
        System.out.println("... 5 seconds after");

        return ok("ahihi");
    }

//    public DeferredResult<String> timeSleepAsync(Long time) throws InterruptedException { //DeferredResult<String>
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        DeferredResult<String> deferredResult = new DeferredResult<>();
//
//        CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(time);
//                deferredResult.setResult("ok");
//            } catch (Exception e) {
//                deferredResult.setErrorResult( e );
//                Thread.currentThread().interrupt();
//            }
//
//        }, executorService);
//
//        return deferredResult;
//    }
}
