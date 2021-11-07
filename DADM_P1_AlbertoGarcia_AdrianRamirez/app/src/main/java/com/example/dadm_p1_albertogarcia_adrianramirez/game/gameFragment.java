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

public class gameFragment extends Fragment {

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
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        //numberOfQuestions= sharedPreferences.getInt("numberOfQuestions",5);
        numberOfQuestions=2;
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rand= new Random();
        randomNumbers= new ArrayList<>();
        for (int i=0;i<2;i++){
            boolean added=false;
            while(!added){
                int rNumber=rand.nextInt(2);
                if(!randomNumbers.contains(rNumber)) {
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
        correctAnswer=databaseViewModel.getAnswer(questionAct);
        return inflater.inflate(R.layout.game_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nextQuestion = view.findViewById(R.id.buttonCheck);

        nextQuestion.setOnClickListener(v -> {

            if (TextUtils.isEmpty(answerAct)) answerNotSelectedNotification.show();
            else {
                if (answerAct.equals("Miguel")) {
                    answer = true;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("answer", answer);

                getParentFragmentManager().setFragmentResult("answerPass", bundle);
                randomNumberIdx++;
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
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Bundle objectT = new Bundle();
        objectT.getInt("actualQuestion",questionAct);
        transaction.replace(R.id.questionLayout, questionFragment.class, objectT);
        transaction.replace(R.id.answerLayout, answerFragment.class, objectT);
        transaction.commit();
    }



}