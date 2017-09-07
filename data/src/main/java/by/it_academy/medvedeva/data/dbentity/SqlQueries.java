package by.it_academy.medvedeva.data.dbentity;

/**
 * Created by Medvedeva Anastasiya
 * on 04.09.2017.
 */

public class SqlQueries {

    public static final String ALL_USERS = "SELECT * FROM user";
    public static final String USERS_FIELD_ID_AND_NAME = "SELECT id, name FROM user";
    public static final String USERS_WITH_COUNTRY = "SELECT * FROM user WHERE countryId =1";
    public static final String USERS_WITH_NAME = "SELECT * FROM user WHERE name = 'someName'";

    public static final String ALL_USERS_WITH_COUNTRY_INNER_JOIN = "SELECT * FROM user INNER JOIN country ON user.countryId = country.id";

    // вернет еще и тех юзеров, у которых есть id страны, не найденный в базе со странами
    public static final String ALL_USERS_WITH_COUNTRY_LEFT_JOIN = "SELECT * FROM user LEFT JOIN country ON user.countryId = country.id";

    // вернет еще и те страны, у которых есть id страны, не найденный в базе с юзерами
    public static final String ALL_USERS_WITH_COUNTRY_RIGHT_JOIN = "SELECT * FROM user RIGHT JOIN country ON user.countryId = country.id";


    public static final String SOME_USERS_WITH_COUNTRY_RIGHT_JOIN = "SELECT * FROM user RIGHT JOIN country ON user.countryId = country.id WHERE <какое то условие>";

    public static final String LIMIT_USERS = "SELECT * FROM user LIMIT 20";

    public static final String OFSET_LIMIT_USERS = "SELECT * FROM user LIMIT 20 OFFSET 20";

    public static final String USERS_SORT_BY_AGE = "SELECT * FROM user ORDER BY age ASC|DESC"; //(ПО ВОЗРАСТАНИЮ | ПО УБЫВАНИЮ)


}
