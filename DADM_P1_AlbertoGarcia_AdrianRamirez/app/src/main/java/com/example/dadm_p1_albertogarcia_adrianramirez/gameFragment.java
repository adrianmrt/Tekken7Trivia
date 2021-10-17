package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class gameFragment extends Fragment {

    boolean answer;

    Toast answerNotSelectedNotification;

    //questions setters
    View rootView;
    String playerName;
    FragmentManager fragmentManager;

    Parcelable[] questions;
    Button nextQuestion;
    int questionAct; //actual question we are on
    String answerAct; //answer selected

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        answerNotSelectedNotification = Toast.makeText(getActivity(), "Selecciona una respuesta", Toast.LENGTH_SHORT);

        //creation of object that receives data from gameFragment
        getChildFragmentManager().setFragmentResultListener("answerChoose", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                answerAct = bundle.getString("answer");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        questionAct = 0;

        // Inflate the layout for this fragment
        Bundle passData = getArguments();
        playerName = passData.getString("playerName");
        questions = passData.getParcelableArray("questions");
        fragmentManager = getChildFragmentManager();

        setQuestion();

        return inflater.inflate(R.layout.game_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nextQuestion = view.findViewById(R.id.buttonCheck);

        nextQuestion.setOnClickListener(v -> {
            String correctAnswer = accessQuestionAct().get_answer();

            if (TextUtils.isEmpty(answerAct)) answerNotSelectedNotification.show();
            else {
                if (answerAct.equals(correctAnswer)) {
                    answer = true;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("answer", answer);

                getParentFragmentManager().setFragmentResult("answerPass", bundle);

                questionAct++;
                if (questionAct < questions.length) {
                    setQuestion();
                } else {
                    getParentFragmentManager().setFragmentResult("finished", bundle);
                }
                answer = false;
                answerAct = "";
            }
        });
    }

    public void setQuestion() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Bundle objectT = new Bundle();

        objectT.putParcelable("question", questions[questionAct]);

        transaction.replace(R.id.questionLayout, questionFragment.class, objectT);
        transaction.replace(R.id.answerLayout, answerFragment.class, objectT);
        transaction.commit();
    }

    private QuestionStructure accessQuestionAct() {
        return (QuestionStructure) questions[questionAct];
    }
}