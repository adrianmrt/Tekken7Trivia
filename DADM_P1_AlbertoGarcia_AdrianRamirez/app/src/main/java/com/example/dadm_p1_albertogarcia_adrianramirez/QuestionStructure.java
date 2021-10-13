package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionStructure implements Parcelable {
    int _questionType; //0 txt, 1 img
    int _answerType; //0 txt, 1 img
    int[]_images;
    String _answer;

    public QuestionStructure(int questionType, int answerType, String answer){
        _questionType=questionType;
        _answer=answer;
        _answerType=answerType;
    }

    protected QuestionStructure(Parcel in) {
        _questionType = in.readInt();
        _answerType = in.readInt();
        _images = in.createIntArray();
        _answer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_questionType);
        dest.writeInt(_answerType);
        dest.writeIntArray(_images);
        dest.writeString(_answer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionStructure> CREATOR = new Creator<QuestionStructure>() {
        @Override
        public QuestionStructure createFromParcel(Parcel in) {
            return new QuestionStructure(in);
        }

        @Override
        public QuestionStructure[] newArray(int size) {
            return new QuestionStructure[size];
        }
    };

    public String get_answer() {
        return _answer;
    }

    public int get_answerType() {
        return _answerType;
    }

    public int get_questionType() {
        return _questionType;
    }

    public int[] get_images() {
        return _images;
    }

}
