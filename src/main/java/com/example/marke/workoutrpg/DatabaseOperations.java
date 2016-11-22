package com.example.marke.workoutrpg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.marke.workoutrpg.TableData.TableInfo;

/**
 * Created by marke on 10/18/2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user_info";
    public static final String CREATE_ENTRIES =
            "CREATE TABLE " + TableInfo.TABLE_NAME + " (" + TableInfo.USER_NAME
            + " TEXT," + TableInfo.USER_PASS + " TEXT," + TableInfo.BACK + " REAL," + TableInfo.BICEPS + " REAL,"
            + TableInfo.CALVES + " REAL," + TableInfo.CHEST + " REAL," + TableInfo.CORE + " REAL," + TableInfo.QUADRICEPS
            + " REAL," + TableInfo.SHOULDERS + " REAL," + TableInfo.TRICEPS + " REAL )";

    public DatabaseOperations(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ENTRIES);
        Log.d("Database operations", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInfo (DatabaseOperations dbo, String name, String pass) {
        SQLiteDatabase sq = dbo.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.USER_NAME, name);
        cv.put(TableInfo.USER_PASS, pass);
        cv.put(TableInfo.BACK, 0.00);
        cv.put(TableInfo.BICEPS, 0.00);
        cv.put(TableInfo.CALVES, 0.00);
        cv.put(TableInfo.CHEST, 0.00);
        cv.put(TableInfo.CORE, 0.00);
        cv.put(TableInfo.QUADRICEPS, 0.00);
        cv.put(TableInfo.SHOULDERS, 0.00);
        cv.put(TableInfo.TRICEPS, 0.00);
        long k = sq.insert(TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "Entry inserted into table");
    }

    public Cursor getInfo(DatabaseOperations dbo) {
        SQLiteDatabase sq = dbo.getReadableDatabase();
        String[] columns = {TableInfo.USER_NAME, TableInfo.USER_PASS, TableInfo.BACK, TableInfo.BICEPS,
        TableInfo.CALVES, TableInfo.CHEST, TableInfo.CORE, TableInfo.QUADRICEPS, TableInfo.SHOULDERS, TableInfo.TRICEPS};
        Cursor cr = sq.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return cr;
    }

    public Cursor getInfoUser(DatabaseOperations dbo, String username) {
        SQLiteDatabase sq = dbo.getReadableDatabase();
        String[] columns = {TableInfo.USER_NAME, TableInfo.USER_PASS, TableInfo.BACK, TableInfo.BICEPS,
                TableInfo.CALVES, TableInfo.CHEST, TableInfo.CORE, TableInfo.QUADRICEPS, TableInfo.SHOULDERS, TableInfo.TRICEPS};
        String selection = TableInfo.USER_NAME + " = ?";
        String[] selectionArgs = { username };
        Cursor cr = sq.query(TableInfo.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        return cr;
    }

}
