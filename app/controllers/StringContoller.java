package controllers;

import org.apache.commons.lang3.RandomStringUtils;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by helix on 8/22/2016.
 */
public class StringContoller extends Controller {

    public Result createRamdomWords(int quantity, int length) {
        for (int i = 0; i < quantity; i++) {
            System.out.println((RandomStringUtils.randomAlphanumeric(length)));
        }
        return ok("ok");
    }

    public Result createRandomFile() {
        for (int i = 0; i < 50; i++) {
            List<String> lines = Arrays.asList(RandomStringUtils.randomAlphanumeric(1024), "The second line");
            java.nio.file.Path file = Paths.get("disk 50k 10k/50k10k " + i + ".txt");
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ok("ok");
    }

}
