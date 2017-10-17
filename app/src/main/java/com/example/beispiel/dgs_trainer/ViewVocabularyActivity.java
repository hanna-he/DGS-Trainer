package com.example.beispiel.dgs_trainer;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Beispiel on 26.09.2017.
 */

public class ViewVocabularyActivity extends AppCompatActivity implements OnSelectedWordListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_vocabulary);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ListFragment vocabularyListFragment = new VocabularyListFragment();
        ft.add( R.id.rootLayoutVocabs, vocabularyListFragment, "vocabularyListFragement" );
        ft.addToBackStack(null);
        ft.commit();


    }

    @Override
    public void onSelectedWordChanged(Vocable vocable) {

        FragmentManager fm = getFragmentManager();
        ShowWordFragment showWordFragment = (ShowWordFragment) fm.findFragmentByTag("showWordFragment");

        if(showWordFragment==null||!showWordFragment.isVisible()){
            FragmentTransaction ft = fm.beginTransaction();
            showWordFragment = new ShowWordFragment();
            Bundle args = new Bundle();
            args.putParcelable(ShowWordFragment.VOCABLE_OBJECT, vocable);
            showWordFragment.setArguments(args);
            ft.replace(R.id.rootLayoutVocabs, showWordFragment, "showWordFragment");
            ft.addToBackStack(null);
            ft.setCustomAnimations(    android.R.animator.fade_in, android.R.animator.fade_out);
            ft.commit();
        }else{
            showWordFragment = (ShowWordFragment) fm.findFragmentById(R.id.show_word_fragment);
            showWordFragment.setWord(vocable);
        }





    }


}
