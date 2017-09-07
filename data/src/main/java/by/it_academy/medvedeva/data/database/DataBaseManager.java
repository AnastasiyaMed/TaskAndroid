package by.it_academy.medvedeva.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import by.it_academy.medvedeva.data.dbentity.Country;
import by.it_academy.medvedeva.data.dbentity.User;

/**
 * Created by Medvedeva Anastasiya
 * on 06.09.2017.
 */

public class DataBaseManager {
    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DataBaseManager(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public void open(boolean isWritable) {
        if (!isWritable) {
            sqLiteDatabase = dbHelper.getReadableDatabase();
        } else {
            sqLiteDatabase = dbHelper.getWritableDatabase();
        }

    }

    public void close() {
        if (sqLiteDatabase != null) {
            sqLiteDatabase.close();
        }
    }

    public void insertUser(User user) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO user ('name', 'age', 'countryId')");
        query.append("VALUES ( '");
        query.append(user.getName());
        query.append("', ");
        query.append(user.getAge());
        query.append(", ");
        query.append(user.getCountry().getId());
        query.append(")");

        //INSERT INTO user ('name', 'age', 'countryId') VALUES ('Name', 25, 0)

        Log.e("DatabaseManager", "insertUser() query=" + query.toString());
        sqLiteDatabase.execSQL(query.toString());
    }

    public void updateUser(User user) {

    }

    public List<User> getUsers() {
        return null;
    }

    public User getUserById(String id) {
        //StringBuilder getByIdQuery = new StringBuilder();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user INNER JOIN country ON user.countryId = country.id WHERE id = ?",
                new String[]{String.valueOf(id)});
        if (cursor != null) {
            User user = new User();
            cursor.moveToFirst();
            int userid = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);

            int countryId = cursor.getInt(3);
            String countryName = cursor.getString(4);

            Country country = new Country(countryId, countryName);

            user.setName(name);
            user.setAge(age);
            user.setId(id);
            user.setCountry(country);

            cursor.close();
            return user;

        } else {
            Log.e(getClass().getName(), "getUserById() cursorr is null");
        }
        return null;
    }


}
