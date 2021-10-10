package com.example.dadm_p1_albertogarcia_adrianramirez;

public class QuestionStructure {
    int _questionType; //0 txt, 1 img
    int _answerType; //0 txt, 1 img
    int[]_images;
    int _answer;

    public QuestionStructure(int questionType, int answerType, int answer, int[]images){
        _questionType=questionType;
        _answer=answer;
        _answerType=answerType;
        _images=images;
    }

    public QuestionStructure(int questionType, int answerType, int answer){
        _questionType=questionType;
        _answer=answer;
        _answerType=answerType;
    }

    public int get_answer() {
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
