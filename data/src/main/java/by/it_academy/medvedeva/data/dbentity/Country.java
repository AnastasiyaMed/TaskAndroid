package by.it_academy.medvedeva.data.dbentity;

/**
 * Created by Medvedeva Anastasiya
 * on 04.09.2017.
 */

public class Country {

    private String code;
    private String name;

    public Country() {
    }

    public Country(String id, String name) {
        this.code = id;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
