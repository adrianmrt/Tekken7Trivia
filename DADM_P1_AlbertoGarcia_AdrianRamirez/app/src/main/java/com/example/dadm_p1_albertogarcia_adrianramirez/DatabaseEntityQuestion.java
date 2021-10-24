package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity (tableName = "Questions")
public class DatabaseEntityQuestion {

    @PrimaryKey
    int questionId;
    @NonNull
    @ColumnInfo
    int _questionType; //0 txt, 1 img
    @NonNull
    @ColumnInfo
    int _answerType; //0 txt, 1 img
    @NonNull
    @ColumnInfo
    ArrayList<Bitmap> _images; //0 question,1-3 answers
    @NonNull
    @ColumnInfo
    String _answer;
    @NonNull
    @ColumnInfo
    String _question;
    @NonNull
    @ColumnInfo
    ArrayList<String> _possibleAnswers;

    public DatabaseEntityQuestion(int id, int questionType, int answerType, ArrayList<Bitmap> images, String answer, String question, ArrayList<String> possibleAnswers) {
        questionId=id;
        _questionType = questionType;
        _answer = answer;
        _answerType = answerType;
        _images = images;
        _question = question;
        _possibleAnswers = possibleAnswers;
    }

    public DatabaseEntityQuestion() {
    }

    public String get_answer() {
        return _answer;
    }

    public int get_answerType() {
        return _answerType;
    }

    public int get_questionType() {
        return _questionType;
    }

    public ArrayList<Bitmap> get_images() {
        return _images;
    }

    public String get_question() {
        return _question;
    }

    public ArrayList<String> get_possibleAnswers() {
        return _possibleAnswers;
    }
}