package by.academy.medvedeva.testandroid.classwork16;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Medvedeva Anastasiya
 * on 08.09.2017.
 */

public class UserR extends RealmObject{
    @PrimaryKey
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public UserR() {
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
}
