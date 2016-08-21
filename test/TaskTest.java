import models.Task;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

public class TaskTest {

    @Test
    public void create() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Task task = new Task();
                task.setId("123");
                task.save();
                assertThat(task.id).isNotNull();
            }
        });
    }

}