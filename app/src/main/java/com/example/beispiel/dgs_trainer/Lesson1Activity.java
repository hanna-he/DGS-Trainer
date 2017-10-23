package com.example.beispiel.dgs_trainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beispiel on 21.09.2017.
 */

public class Lesson1Activity extends AppCompatActivity {
    private List<Vocable> vocabulary;
    private static final String LOG_TAG = Lesson1Activity.class.getSimpleName();
    private VocabularyDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lesson1_startpage);
        doDatabaseStuff();

        Button view_vocabulary_button = (Button) findViewById(R.id.lesson1_startpage_button1);

        view_vocabulary_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vocabularyIntent = new Intent(Lesson1Activity.this, ViewVocabularyActivity.class);
                startActivity(vocabularyIntent);
            }
        });
    }

    private void doDatabaseStuff(){
        Vocable testVocable = new Vocable();
        testVocable.setVideoID(R.raw.sample_video);
        testVocable.setWord("Test123");
        testVocable.setExampleUse("beispielTest");
        testVocable.setMnemonic(1234);
        List<Vocable> list = new ArrayList<>();
        testVocable.setOtherDialects(list);



        Log.d(LOG_TAG, "Inhalt der Testmemo: " + testVocable.toString());

        dataSource = new VocabularyDataSource (this);




        Log.d(LOG_TAG, "Die Datenquelle wird geöffnet.");
        dataSource.open();

        dataSource.insertVocableToDatabase(testVocable);

        Log.d(LOG_TAG, "Vokabeln aus Datenbanke: \n");
        vocabulary= dataSource.getAllVocables();

        Log.d(LOG_TAG, "Die Datenquelle wird geschlossen.");
        dataSource.close();

    }

    public List<Vocable> getVocabularyList(){
        return this.vocabulary;
    }

}
