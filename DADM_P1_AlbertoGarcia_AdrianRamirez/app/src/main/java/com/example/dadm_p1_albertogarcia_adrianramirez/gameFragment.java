package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class gameFragment extends Fragment {

    boolean answerRight;
    Button nextQuestion;

    //questions setters
    View rootView;
    FragmentManager fragM;
    Parcelable[] _questions;
    int questionAct; //actual question we are on
    String answerAct; //answer selected

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //creation of object that receives data from gameFragment
        getChildFragmentManager().setFragmentResultListener("answerChoose", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                answerAct = bundle.getString("answer");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        questionAct = 0;
        // Inflate the layout for this fragment
        Bundle passData = getArguments();
        _questions = passData.getParcelableArray("questions");
        fragM = getChildFragmentManager();
        setQuestion();
        return inflater.inflate(R.layout.game_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nextQuestion = view.findViewById(R.id.buttonCheck);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correctAnswer=accessQuestionAct().get_answer();
                if (answerAct.equals(correctAnswer)) {
                    answerRight = true;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("answer", answerRight);
                getParentFragmentManager().setFragmentResult("answerPass", bundle);
                if(questionAct!=_questions.length-1){
                    questionAct++;
                    setQuestion();
                }
                answerRight = false;
            }
        });
    }

    public void setQuestion() {
        FragmentTransaction transaction = fragM.beginTransaction();
        Bundle objectT = new Bundle();
        objectT.putParcelable("question", _questions[questionAct]);
        transaction.replace(R.id.questionLayout, questionFragment.class, objectT);
        transaction.replace(R.id.answerLayout, answerFragment.class, objectT);
        transaction.commit();
    }

    private QuestionStructure accessQuestionAct() {
        return (QuestionStructure) _questions[questionAct];
    }
}