package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task extends com.avaje.ebean.Model {

    public static Find<Long, Task> find = new Find<Long, Task>() {
    };

    @Id
    public String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getContents() {
        return name;
    }

    public void setContents(String contents) {
        this.name = contents;
    }

    public String name;

    public static java.util.List<Task> findAll() {
        return find.all();
    }
}