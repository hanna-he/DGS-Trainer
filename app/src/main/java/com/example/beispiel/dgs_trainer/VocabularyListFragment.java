package com.example.beispiel.dgs_trainer;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beispiel on 26.09.2017.
 */

public class VocabularyListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        String[] vocabulary_list = getResources().getStringArray(R.array.vocabulary_array);
        ArrayAdapter<String> VocabularyListAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, vocabulary_list);
        setListAdapter(VocabularyListAdapter);

    }


    public void onListItemClick(ListView listView, View view, int position, long id){
        OnSelectedWordListener listener = (OnSelectedWordListener) getActivity();
        Vocable vocable = new Vocable();
        vocable.setVideoID(R.raw.sample_video);
        vocable.setWord("Frau");
        vocable.setExampleUse("beispiel");
        vocable.setMnemonic("Eselsbrücke");
        List<Vocable> list = new ArrayList<>();
        vocable.setOtherDialects(list);
        listener.onSelectedWordChanged(vocable);
    }




}
