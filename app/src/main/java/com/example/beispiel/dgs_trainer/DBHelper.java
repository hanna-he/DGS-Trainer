package com.example.beispiel.dgs_trainer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Beispiel on 17.10.2017.
 */

public class DBHelper extends SQLiteOpenHelper {


    private static final String LOG_TAG = DBHelper.class.getSimpleName();
    public static final String DB_NAME = "vocabulary.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_VOCABULARY_LIST = "vocabulary_list";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WORD = "word";
    public static final String COLUMN_VIDEOID = "video_id";
    public static final String COLUMN_EXAMPLEUSE = "example_use";
    public static final String COLUMN_MNEMONIC = "mnemonic";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_VOCABULARY_LIST +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_WORD + " TEXT NOT NULL, " +
                    COLUMN_VIDEOID + " INTEGER NOT NULL," +
                    COLUMN_EXAMPLEUSE + " TEXT NOT NULL, " +
                    COLUMN_MNEMONIC + " TEXT NOT NULL );";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(LOG_TAG, "Database: " + getDatabaseName() + " created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d(LOG_TAG, "Creating table was succesful with: " + SQL_CREATE );
            db.execSQL(SQL_CREATE);
        } catch (Exception ex) {
            Log.e(LOG_TAG, "Error creating table: " + ex.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
