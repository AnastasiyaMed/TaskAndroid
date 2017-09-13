package by.it_academy.medvedeva.taskandroid.entity;

/**
 * Created by Medvedeva Anastasiya
 * on 04.09.2017.
 */

public class UserDomain {

    private int id;
    private String name;
    private int age;
    private CountryDomain countryDomain;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CountryDomain getCountryDomain() {
        return countryDomain;
    }

    public void setCountryDomain(CountryDomain countryDomain) {
        this.countryDomain = countryDomain;
    }
}
