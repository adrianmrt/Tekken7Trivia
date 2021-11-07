package com.example.dadm_p1_albertogarcia_adrianramirez.game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;

public class QuestionFragment extends Fragment {

    int type;
    View rootView;
    QuestionStructure _question;

    //Layout elements
    ImageView img1;

    TextView questionText;

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
        if(_question.get_questionType()==0) {
            rootView = inflater.inflate(R.layout.question_text_layout, container, false);
            questionText= rootView.findViewById(R.id.textQuestionText);
            questionText.setText(_question.get_question());

        }else{
            rootView = inflater.inflate(R.layout.question_img_layout, container, false);
            questionText= rootView.findViewById(R.id.textQuestionImg);
            questionText.setText(_question.get_question());
            img1=rootView.findViewById(R.id.imgQuestion);
            img1.setImageResource(_question.get_images()[0]);
        }
        return rootView;
    }
}