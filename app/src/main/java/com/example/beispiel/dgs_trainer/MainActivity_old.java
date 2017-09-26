package com.example.beispiel.dgs_trainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity_old extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new LessonAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "" + position+" "+R.drawable.lektion2,Toast.LENGTH_SHORT).show();

                Intent nextlesson = getLessonclicked(position);
                startActivity(nextlesson);
            }
        });*/
       Button button1 = (Button) findViewById(R.id.button1);{

        }
    }

    private Intent getLessonclicked(int position){
        switch(position){
            case 0:
                return new Intent(MainActivity_old.this, Lesson1Activity.class);
            case 1:
                return new Intent(MainActivity_old.this, Lesson2Activity.class);
            default:
                return new Intent(MainActivity_old.this, Lesson3Activity.class);
            }
        }

}
