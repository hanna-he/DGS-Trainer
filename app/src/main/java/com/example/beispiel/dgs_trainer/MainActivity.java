package com.example.beispiel.dgs_trainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_lesson1= new Intent(MainActivity.this, Lesson1Activity.class);
                startActivity(intent_lesson1);
            }
        });

    }

    private Intent getLessonclicked(int position){
        switch(position){
            case 0:
                return new Intent(MainActivity.this, Lesson1Activity.class);
            case 1:
                return new Intent(MainActivity.this, Lesson2Activity.class);
            default:
                return new Intent(MainActivity.this, Lesson3Activity.class);
        }
    }

}
