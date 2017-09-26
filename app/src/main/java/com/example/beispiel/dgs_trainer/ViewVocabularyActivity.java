package com.example.beispiel.dgs_trainer;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.ArrayList;

/**
 * Created by Beispiel on 26.09.2017.
 */

public class ViewVocabularyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_vocabulary);
        ListView vocabularyListView = (ListView) findViewById(R.id.vocabulary_list_view);
        String[] vocabularyList = getResources().getStringArray(R.array.vocabulary_array);
        vocabularyListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, vocabularyList));


    }


}
