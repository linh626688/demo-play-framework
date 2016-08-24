package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Task extends Model {



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


}