package com.example.beispiel.dgs_trainer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beispiel on 08.10.2017.
 */

public class Vocable implements Parcelable {

    public static final Parcelable.Creator<Vocable> CREATOR = new Parcelable.Creator<Vocable>() {
        @Override
        public Vocable createFromParcel(Parcel source) {
            return new Vocable(source);
        }

        @Override
        public Vocable[] newArray(int size) {
            return new Vocable[size];
        }
    };
    private String word;
    private int videoID;
    private String exampleUse;
    private int mnemonic;
    private List<Vocable> otherDialects;

    public Vocable() {
    }

    public Vocable(Parcel parcel) {
        this.word = parcel.readString();
        this.videoID = parcel.readInt();
        this.exampleUse = parcel.readString();
        this.mnemonic = parcel.readInt();
        List<Vocable> list = new ArrayList<>();
        parcel.readList(list, List.class.getClassLoader());
        this.otherDialects = list;

    }

    public Vocable(String word, int videoID, String exampleUse, int mnemonic) {
        this.word = word;
        this.videoID = videoID;
        this.exampleUse = exampleUse;
        this.mnemonic = mnemonic;
       // this.otherDialects = otherDialects;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }

    public String getExampleUse() {
        return exampleUse;
    }

    public void setExampleUse(String exampleUse) {
        this.exampleUse = exampleUse;
    }

    public int getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(int mnemonic) {
        this.mnemonic = mnemonic;
    }

    public List<Vocable> getOtherDialects() {
        return otherDialects;
    }

    public void setOtherDialects(List<Vocable> otherDialects) {
        this.otherDialects = otherDialects;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(word);
        parcel.writeInt(videoID);
        parcel.writeString(exampleUse);
        parcel.writeInt(mnemonic);
        parcel.writeList(otherDialects);
    }

    @Override
    public String toString(){
        return this.getWord();
    }

    @Override
    public int hashCode(){
        return word.hashCode()+this.videoID;
    }
}
