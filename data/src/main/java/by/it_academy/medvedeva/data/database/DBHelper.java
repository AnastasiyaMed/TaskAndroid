package by.it_academy.medvedeva.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Medvedeva Anastasiya
 * on 06.09.2017.
 */

class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "test";
    private static final int VERSION = 4;

// sqLite не потокобезопасный и выполняется в UI потоке

    DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("DBHelper", "onCreate()");
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS user ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "'name' TEXT ,'age' INTEGER , 'countryId' INTEGER)");

            db.execSQL("CREATE TABLE IF NOT EXISTS country ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "'name' TEXT)");
            Log.e("DBHelper", "createComplete");
        } catch (Exception exception) {
            Log.e("DBHelper", exception.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("DBHelper", "onUpgrade()");
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS country");
        onCreate(db);
    }

}
