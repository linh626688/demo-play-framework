package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task extends Model {

    @Id
    public int id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public boolean done;

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dueDate = new Date();

    public static Finder<Long, Task> find = new Finder<Long, Task>(Task.class);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}