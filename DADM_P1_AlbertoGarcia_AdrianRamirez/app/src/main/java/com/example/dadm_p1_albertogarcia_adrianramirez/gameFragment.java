package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class gameFragment extends Fragment {

    boolean answer = true;
    Button nextQuestion;

    //question type setters
    View rootView;
    FragmentManager fragM;
    int type; //0 text, 1 img

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        type = 0;
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
                Bundle bundle = new Bundle();
                bundle.putBoolean("answer", answer);
                getParentFragmentManager().setFragmentResult("answerPass", bundle);
                type=1;
                setQuestion();
            }
        });
    }

    public void setQuestion() {
        FragmentTransaction transaction = fragM.beginTransaction();
        Bundle objectT = new Bundle();
        objectT.putInt("type", type);

        transaction.replace(R.id.questionLayout, questionFragment.class, objectT);
        transaction.replace(R.id.answerLayout, answerFragment.class, objectT);
        transaction.commit();
    }
}