package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by helix on 8/22/2016.
 */
public class CpuController extends Controller{
    public void testHighCpu(int max) {
        double temp = 0;

        for (int i = 0; i < max; i++) {
            temp = Math.sin(i);
        }

        for (int i = 0; i < max; i++) {
            temp = Math.cos(i);
        }

        for (int i = 0; i < max; i++) {
            temp = Math.tan(i);
        }
    }

    public Result testCpu(int max) {
        testHighCpu(max);
        return ok("OK");
    }
}
