package com.example.beispiel.dgs_trainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Beispiel on 21.09.2017.
 */

public class Lesson1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lesson1_startpage);

        Button view_vocabulary_button= (Button) findViewById(R.id.lesson1_startpage_button1);

        view_vocabulary_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent vocabularyIntent = new Intent(Lesson1Activity.this, ViewVocabularyActivity.class);
                startActivity(vocabularyIntent);
            }
        });
    }
}
