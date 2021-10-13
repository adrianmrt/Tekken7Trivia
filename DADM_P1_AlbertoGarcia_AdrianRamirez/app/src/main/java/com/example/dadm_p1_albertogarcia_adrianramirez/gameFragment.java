package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.content.Intent;
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

    boolean answer = true;

    //questions setters
    View rootView;
    String playerName;
    FragmentManager fragmentManager;

    Parcelable[] _questions;
    Button nextQuestion;
    int questionAct; //actual question we are on

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        questionAct = 0;

        // Inflate the layout for this fragment
        Bundle passData = getArguments();
        playerName = passData.getString("playerName");
        _questions = passData.getParcelableArray("questions");
        fragmentManager = getChildFragmentManager();

        setQuestion();

        return inflater.inflate(R.layout.game_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nextQuestion = view.findViewById(R.id.buttonCheck);
        nextQuestion.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putBoolean("answer", answer);

            getParentFragmentManager().setFragmentResult("answerPass", bundle);

            questionAct++;

            if (questionAct < _questions.length){
                setQuestion();
            } else {
                getParentFragmentManager().setFragmentResult("finished", bundle);
            }

        });
    }

    public void setQuestion() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Bundle objectT = new Bundle();

        objectT.putParcelable("question",_questions[questionAct]);

        transaction.replace(R.id.questionLayout, questionFragment.class, objectT);
        transaction.replace(R.id.answerLayout, answerFragment.class, objectT);
        transaction.commit();
    }
}