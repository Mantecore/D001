package util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
