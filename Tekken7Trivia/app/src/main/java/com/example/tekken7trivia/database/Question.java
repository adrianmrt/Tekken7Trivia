package com.example.tekken7trivia.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "Questions")
public class Question {

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
    String _answer;
    @NonNull
    @ColumnInfo
    String _question;
    @NonNull
    @ColumnInfo
    ArrayList<String> _possibleAnswers;

    @NonNull
    @ColumnInfo
    ArrayList<String> _images; //0 question,1-3 answers

    @NonNull
    @ColumnInfo
    String _questionBlock;

    @NonNull
    @ColumnInfo
    String _multimediaFileId;

    public void set_answer(@NonNull String _answer) {
        this._answer = _answer;
    }

    public void set_answerType(int _answerType) {
        this._answerType = _answerType;
    }

    public void set_images(@NonNull ArrayList<String> _images) {
        this._images = _images;
    }

    public void set_possibleAnswers(@NonNull ArrayList<String> _possibleAnswers) {
        this._possibleAnswers = _possibleAnswers;
    }

    public void set_question(@NonNull String _question) {
        this._question = _question;
    }

    public void set_questionType(int _questionType) {
        this._questionType = _questionType;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void set_questionBlock(@NonNull String _questionBlock) {
        this._questionBlock = _questionBlock;
    }

    public void set_multimediaFileId(String _multimediaFileId) {
        this._multimediaFileId = _multimediaFileId;
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

    public ArrayList<String> get_images() {
        return _images;
    }

    public String get_question() {
        return _question;
    }

    public ArrayList<String> get_possibleAnswers() {
        return _possibleAnswers;
    }

    @NonNull
    public String get_questionBlock() {
        return _questionBlock;
    }

    public String get_multimediaFileId() {
        return _multimediaFileId;
    }
}
