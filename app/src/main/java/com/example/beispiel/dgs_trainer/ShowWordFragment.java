package com.example.beispiel.dgs_trainer;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by Beispiel on 08.10.2017.
 */

public class ShowWordFragment extends Fragment {

    public static final String VOCABLE_OBJECT = "vocable_object";
    private TextView textView;
    private VideoView videoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewHierarchy = inflater.inflate(R.layout.fragment_show_word, container, false);
        textView = (TextView) viewHierarchy.findViewById(R.id.show_word_textView);
        videoView = (VideoView) viewHierarchy.findViewById(R.id.show_word_videoView);
        MediaController mediaController = new MediaController(getActivity());
        videoView.setMediaController(mediaController);
        Bundle args = getArguments();
        Vocable vocable;
        if (args != null) {
            vocable = (Vocable) args.get(VOCABLE_OBJECT);
            System.out.println("TEST : " + vocable.getWord());
            setWord(vocable);
        } else {
            Log.e("Error", "no Vocable set in Arguments");
            //Uri uri = Uri.parse("android.resource://com.example.beispiel.dgs_trainer/"+R.raw.sample_video);
            Vocable vocable2 = new Vocable();
            vocable2.setWord("LAlala");
            setWord(vocable2);
        }


        return viewHierarchy;
    }

    public void setWord(Vocable vocable) {
        //hoer muss auf entsprechende Stelle im Array zugegriffen werden
        textView.setText(vocable.getWord());
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + vocable.getVideoID());
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}
