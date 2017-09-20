package by.it_academy.medvedeva.taskandroid.entity;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public class RegisterDomain implements DomainModel {
    private String name;
    private String password;

    public RegisterDomain() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
