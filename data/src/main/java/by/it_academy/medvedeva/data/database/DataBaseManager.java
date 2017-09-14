package by.it_academy.medvedeva.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
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
        Log.e("DatabaseManager", "insertUser() ");
        query.append("INSERT INTO user ('name', 'age', 'country')");
        query.append(" VALUES ( '");
        query.append(user.getName());
        query.append("', ");
        query.append(user.getAge());
        query.append(", '");
        query.append(user.getCountry().getCode());
        query.append("')");

        //INSERT INTO user ('name', 'age', 'countryId') VALUES ('Name', 25, 0)

        Log.e("DatabaseManager", "insertUser() query=" + query.toString());
        sqLiteDatabase.execSQL(query.toString());
    }

    public void updateUser(User user) {
        open(true);
        ContentValues values = new ContentValues();
        values.put("user_name", user.getName());
        values.put("user_age", user.getAge());
        values.put("country", user.getCountry().getCode());

        sqLiteDatabase.update("user", values, "_id" + " = ?", new String[]{String.valueOf(user.getId())});
        close();
    }


    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
     //   String selectQuery = "SELECT * FROM user INNER JOIN country ON user.countryId = country.id";
        String selectQuery = "SELECT * FROM user";

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                Country country = new Country();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setAge(cursor.getInt(2));
                country.setCode(cursor.getString(3));
            //    country.setName(cursor.getString(4));
                user.setCountry(country);

                // Adding user to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // return user list
        return userList;
    }

    public User getUserById(int id) {
        //StringBuilder getByIdQuery = new StringBuilder();

//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user INNER JOIN country ON user.countryId = country.id WHERE id = ?",
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE id = ?", new String[]{String.valueOf(id)});
        if (cursor != null) {
            User user = new User();
            cursor.moveToFirst();
            //  int userid = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);

            String countryCode = cursor.getString(3);

            Country country = new Country();
            country.setCode(countryCode);

            user.setName(name);
            user.setAge(age);
            user.setId(id);
            user.setCountry(country);

            cursor.close();
            return user;

        } else {
            Log.e(getClass().getName(), "getUserById() cursor is null");
            return null;
        }
    }

    public int getUserCount() {

        String countQuery = "SELECT  * FROM user";
        Cursor cursor = sqLiteDatabase.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    // Deleting single contact
    public  void deleteUser(User user) {
        sqLiteDatabase.delete("user", "id" + " = ?", new String[] { String.valueOf(user.getId()) });
    }


}
