package com.example.dadm_p1_albertogarcia_adrianramirez.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFragment extends Fragment {

    boolean answer;

    Toast answerNotSelectedNotification;

    //questions setters
    String playerName;
    FragmentManager fragmentManager;

    Button nextQuestion;
    int questionAct; //actual question we are on
    String answerAct; //answer selected
    String correctAnswer;

    //random questions generation
    int numberOfQuestions;
    DatabaseViewModel databaseViewModel;
    List<Integer>randomNumbers;
    int randomNumberIdx;
    Random rand;
    String questionType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        answerNotSelectedNotification = Toast.makeText(getActivity(), "Selecciona una respuesta", Toast.LENGTH_SHORT);

        //creation of object that receives data from GameFragment
        getChildFragmentManager().setFragmentResultListener("answerChoose", this, (requestKey, bundle) -> answerAct = bundle.getString("answer"));
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        numberOfQuestions= sharedPreferences.getInt("numberOfQuestions",5);
        questionType= sharedPreferences.getString("blockType","general");
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rand= new Random();
        randomNumbers= new ArrayList<>();
        for (int i=0;i<numberOfQuestions;i++){
            boolean added=false;
            while(!added){
                int rNumber=rand.nextInt(5);
                if(!randomNumbers.contains(rNumber)&& databaseViewModel.GetQuestion(rNumber).get_questionBlock().equals(questionType)) {
                    randomNumbers.add(rNumber);
                    added = true;
                }
            }
        }
        randomNumberIdx=0;
        questionAct = randomNumbers.get(randomNumberIdx);
        // Inflate the layout for this fragment
        Bundle passData = getArguments();
        playerName = passData.getString("playerName");
        fragmentManager = getChildFragmentManager();
        setQuestion();
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nextQuestion = view.findViewById(R.id.buttonCheck);

        nextQuestion.setOnClickListener(v -> {

            if (TextUtils.isEmpty(answerAct)) answerNotSelectedNotification.show();
            else {
                if (answerAct.equals(correctAnswer)) {
                    answer = true;
                }

                randomNumberIdx++;
                Bundle bundle = new Bundle();
                bundle.putBoolean("answer", answer);
                bundle.putInt("count", randomNumberIdx);

                getParentFragmentManager().setFragmentResult("answerPass", bundle);

                if (randomNumberIdx < numberOfQuestions) {
                    questionAct=randomNumbers.get(randomNumberIdx);
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
        correctAnswer=databaseViewModel.getAnswer(questionAct);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Bundle objectT = new Bundle();

        //objectT.putParcelable("question", questions[questionAct]);
        objectT.putInt("actualQuestion",questionAct);

        transaction.replace(R.id.questionLayout, QuestionFragment.class, objectT);
        transaction.replace(R.id.answerLayout, AnswerFragment.class, objectT);

        transaction.commit();
    }



}