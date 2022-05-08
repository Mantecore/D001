package util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public DatabaseConnection(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = databaseHelper.getWritableDatabase();
    }

    public void insertUser(String name, double weight, double height, double calculatedBMI) {
        String table = "UserNames";
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("weight", weight);
        values.put("height", height);
        values.put("calculatedBMI", calculatedBMI);
        database.insert(table, null, values);
    }

    public List<String> selectUsernames() {
        String table = "UserNames";
        Cursor result = database.query(table,null,null,null,null,null,null);
        List<String> UserNames = new ArrayList<>();
        if (result != null && result.moveToFirst()) {
            do {
                UserNames.add(result.getString(1));
            } while (result.moveToNext());
            result.close();
        }
        return UserNames;
    }

    public String userName(int id) {
        String table = "UserNames";
        String[] columns = {"name"};
        String selection = "id = ?";
        String[] selectionArgs = {Integer.toString(id)};
        Cursor result = database.query(table,columns,selection,selectionArgs,null,null,null);
        String bmiEntry = null;
        if (result != null && result.moveToFirst()){
            bmiEntry = result.getString(0);
        }
        return bmiEntry;
    }


    public void updateUsername (int id, String name) {
        String table = "UserNames";
        ContentValues values = new ContentValues();
        values.put("name",name);
        String selection = "id = ?";
        String[] selectionArgs = {Integer.toString(id)};
        database.update(table,values,selection,selectionArgs);
    }

    public void deleteUsername(int id) {
        String table = "UserNames";
        String selection = "id = ?";
        String[] selectionArgs =  {
                Integer.toString(id)
        };
        database.delete(table,selection,selectionArgs);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final int databaseVersion = 1;
        private static final String databaseName = "UserNames";

        public DatabaseHelper(Context context) {
            super(context, databaseName, null, databaseVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS UsernNames (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, weight double, height double, calculatedBMI double);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
            database.execSQL("DROP TABLE IF EXISTS UserNames;");
            onCreate(database);
        }
    }

}
