package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;

public class MainConfigFragment extends Fragment {

    RadioGroup nQuestions;

    public MainConfigFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_config, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nQuestions = view.findViewById(R.id.nQuestionsRG);
        nQuestions.setOnCheckedChangeListener((group, checkedId) -> getAnswerChosen());
    }

    private void getAnswerChosen() {
        int _answerID = nQuestions.getCheckedRadioButtonId();
        RadioButton numberSelected = nQuestions.findViewById(_answerID);
        Integer quantity = Integer.parseInt(numberSelected.getText().toString());

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("numberOfQuestions", quantity);
        editor.apply();
    }
}