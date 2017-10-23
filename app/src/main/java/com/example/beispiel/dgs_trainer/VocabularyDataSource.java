package com.example.beispiel.dgs_trainer;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.text.style.TtsSpan;
        import android.util.Log;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Beispiel on 17.10.2017.
 */

public class VocabularyDataSource {


    private static final String LOG_TAG = VocabularyDataSource.class.getSimpleName();

    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] columns = {
            DBHelper.COLUMN_ID,
            DBHelper.COLUMN_WORD,
            DBHelper.COLUMN_VIDEOID,
            DBHelper.COLUMN_EXAMPLEUSE,
            DBHelper.COLUMN_MNEMONIC
    };


    public VocabularyDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        Log.d(LOG_TAG, "Eine Referenz auf die Datenbank wird jetzt angefragt.");
        database = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Datenbank-Referenz erhalten. Pfad zur Datenbank: " + database.getPath());
    }

    public void close() {
        dbHelper.close();
        Log.d(LOG_TAG, "Datenbank mit Hilfe des DbHelpers geschlossen.");
    }

    public void insertVocableToDatabase(Vocable vocable){
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_ID, vocable.hashCode());
        values.put(DBHelper.COLUMN_WORD, vocable.getWord());
        values.put(DBHelper.COLUMN_VIDEOID, vocable.getVideoID());
        values.put(DBHelper.COLUMN_EXAMPLEUSE, vocable.getExampleUse());
        values.put(DBHelper.COLUMN_MNEMONIC, vocable.getMnemonic());
        database.insert(DBHelper.TABLE_VOCABULARY_LIST, null, values);
    }

    private Vocable cursorToVocable(Cursor cursor){
        int idIndex = cursor.getColumnIndex(DBHelper.COLUMN_ID);
        int idWord = cursor.getColumnIndex(DBHelper.COLUMN_WORD);
        int idVideoID = cursor.getColumnIndex(DBHelper.COLUMN_VIDEOID);
        int idExampleUse = cursor.getColumnIndex(DBHelper.COLUMN_EXAMPLEUSE);
        int idMnemonic = cursor.getColumnIndex(DBHelper.COLUMN_MNEMONIC);

        String word = cursor.getString(idWord);
        int videoID = cursor.getInt(idVideoID);
        String exampleUse = cursor.getString(idExampleUse);
        int mnemonic = cursor.getInt(idMnemonic);

        Vocable vocable = new Vocable(word, videoID, exampleUse, mnemonic);
        return vocable;
    }

    public List<Vocable> getAllVocables(){
        List<Vocable> vocabularyList = new ArrayList<>();

        Cursor cursor = database.query(DBHelper.TABLE_VOCABULARY_LIST, columns, null, null, null, null, null);
        cursor.moveToFirst();

        Vocable vocable;
        while(!cursor.isAfterLast()){
            vocable = cursorToVocable(cursor);
            vocabularyList.add(vocable);
            cursor.moveToNext();
        }
        cursor.close();
        return vocabularyList;
    }

}
