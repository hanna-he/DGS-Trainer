package com.example.beispiel.dgs_trainer;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beispiel on 26.09.2017.
 */

public class VocabularyListFragment extends ListFragment {
    private VocabularyDataSource dataSource;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataSource = new VocabularyDataSource(getActivity());
        dataSource.open();



        //String[] vocabulary_list = getResources().getStringArray(R.array.vocabulary_array);
        List<Vocable> vocabulary_list = dataSource.getAllVocables();
        dataSource.close();
        List<String> vocable_list = new ArrayList<>();
        for(Vocable v : vocabulary_list){
            vocable_list.add(v.getWord());
        }
        ArrayAdapter<Vocable> VocabularyListAdapter = new ArrayAdapter<Vocable>(getActivity(),
                android.R.layout.simple_list_item_1, vocabulary_list);
        setListAdapter(VocabularyListAdapter);

    }


    public void onListItemClick(ListView listView, View view, int position, long id) {
        OnSelectedWordListener listener = (OnSelectedWordListener) getActivity();
        Vocable vocable = (Vocable) listView.getItemAtPosition(position);
       // listView.getItemAtPosition(position);
        //TODO: Überleitung von Position in Liste zu Vokabel?!
       /* Vocable vocable = new Vocable();
        vocable.setVideoID(R.raw.sample_video);
        vocable.setWord("Frau");
        vocable.setExampleUse("beispiel");
        vocable.setMnemonic(4567);
        List<Vocable> list = new ArrayList<>();
        vocable.setOtherDialects(list);*/
        listener.onSelectedWordChanged(vocable);
    }


}
