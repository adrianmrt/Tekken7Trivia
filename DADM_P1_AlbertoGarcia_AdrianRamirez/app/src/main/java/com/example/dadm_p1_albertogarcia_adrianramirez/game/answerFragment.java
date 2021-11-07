package com.example.dadm_p1_albertogarcia_adrianramirez.game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.Question;

public class answerFragment extends Fragment {

    int type;
    View rootView;
    int _questionAct;
    DatabaseViewModel questionDatabase;
    Question _question;
    RadioGroup _radioGroup;

    //Layout elements
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;

    ImageView img1;
    ImageView img2;
    ImageView img3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle passData=getArguments();
        _questionAct= passData.getInt("actualQuestion");
        questionDatabase= new ViewModelProvider(this).get(DatabaseViewModel.class);
        _question= questionDatabase.GetQuestion(1);

        if (_question.get_answerType() == 0) {
            rootView = inflater.inflate(R.layout.answer_text_layout, container, false);
            setTextButtons();
        } else {
            rootView = inflater.inflate(R.layout.answer_img_layout, container, false);
            setImgButtons();
        }
        _radioGroup.setOnCheckedChangeListener((group, checkedId) -> getAnswerChosen());
        return rootView;
    }

    private void getAnswerChosen() {
        int _answerID = _radioGroup.getCheckedRadioButtonId();
        RadioButton _answerB = _radioGroup.findViewById(_answerID);
        Bundle bundle = new Bundle();
        bundle.putString("answer", _answerB.getText().toString());
        getParentFragmentManager().setFragmentResult("answerChoose", bundle);
    }

    private void setTextButtons() {
        _radioGroup = rootView.findViewById(R.id.answers_text);
        rb1 = rootView.findViewById(R.id.answerText1);
        rb2 = rootView.findViewById(R.id.answerText2);
        rb3 = rootView.findViewById(R.id.answerText3);

        rb1.setText(_question.get_possibleAnswers().get(0));
        rb2.setText(_question.get_possibleAnswers().get(1));
        rb3.setText(_question.get_possibleAnswers().get(2));
    }

    private void setImgButtons() {
        _radioGroup = rootView.findViewById(R.id.answers_img);
        //buttons
        rb1 = rootView.findViewById(R.id.answerImg1);
        rb2 = rootView.findViewById(R.id.answerImg2);
        rb3 = rootView.findViewById(R.id.answerImg3);

        rb1.setText(_question.get_possibleAnswers().get(0));
        rb2.setText(_question.get_possibleAnswers().get(1));
        rb3.setText(_question.get_possibleAnswers().get(2));

        //img of buttons

        img1 = rootView.findViewById(R.id.img1);
        img2 = rootView.findViewById(R.id.img2);
        img3 = rootView.findViewById(R.id.img3);

        img1.setImageResource(Integer.parseInt(_question.get_images().get(1)));
        img2.setImageResource(Integer.parseInt(_question.get_images().get(2)));
        img3.setImageResource(Integer.parseInt(_question.get_images().get(3)));;
    }
}