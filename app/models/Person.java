package models;

import com.avaje.ebean.Model;
import play.db.DB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by MinhTu on 8/15/2016.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int age;
    private String sex;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Model.Find<Long, Person> find = new Model.Find<Long, Person>() {
    };

    public static java.util.List<Person> findAll() {
        return find.all();
    }

    public boolean savePerson() throws SQLException {
        Connection connection = DB.getConnection();
        String query = "insert into person (name, age, sex,birthday) values (?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.setString(3, sex);
        statement.setDate(4, (java.sql.Date) birthday);

        boolean res = statement.execute();
        connection.close();
        return res;
    }


}
