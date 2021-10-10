package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class answerFragment extends Fragment {

    int type;
    View rootView;
    QuestionStructure _question;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle passData=getArguments();
        _question= passData.getParcelable("question");
        if(_question.get_answerType()==0) {
            rootView = inflater.inflate(R.layout.answer_text_layout, container, false);
        }else{
            rootView = inflater.inflate(R.layout.answer_img_layout, container, false);
        }
        return rootView;
    }
}