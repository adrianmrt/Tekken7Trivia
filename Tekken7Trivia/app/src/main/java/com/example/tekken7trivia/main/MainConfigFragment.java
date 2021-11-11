package com.example.tekken7trivia.main;

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

import com.example.tekken7trivia.R;

public class MainConfigFragment extends Fragment {

    RadioGroup nQuestions;
    RadioGroup typeQuestions;

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
        typeQuestions = view.findViewById(R.id.questionsTypeRG);
        typeQuestions.setOnCheckedChangeListener((group, checkedId) -> getAnswerChosen());
    }

    private void getAnswerChosen() {
        Integer quantity = 5;
        String blockType = "Mixtas";

        int _answerID = nQuestions.getCheckedRadioButtonId();
        RadioButton numberSelected = nQuestions.findViewById(_answerID);
        int _typeID = typeQuestions.getCheckedRadioButtonId();
        RadioButton typeSelected = typeQuestions.findViewById(_typeID);

        if (numberSelected != null) {
            quantity = Integer.parseInt(numberSelected.getText().toString());
            if(quantity==20){
                blockType="Mixtas";
                RadioButton button= getActivity().findViewById(R.id.radioButtonMixed);
                button.setChecked(true);
            }
        }
        if (typeSelected != null) {
            blockType = typeSelected.getText().toString();
        }

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("numberOfQuestions", quantity);
        editor.putString("blockType", blockType);
        editor.apply();
    }
}