package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class answerFragment extends Fragment {

    int type;
    View rootView;
    QuestionStructure _question;
    RadioGroup _radioGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle passData = getArguments();
        _question = passData.getParcelable("question");
        if (_question.get_answerType() == 0) {
            rootView = inflater.inflate(R.layout.answer_text_layout, container, false);
            _radioGroup = rootView.findViewById(R.id.answers_text);
        } else {
            rootView = inflater.inflate(R.layout.answer_img_layout, container, false);
            _radioGroup = rootView.findViewById(R.id.answers_img);
        }
        _radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                getAnswerChosed();
            }
        });

        return rootView;
    }

    private void getAnswerChosed() {
        int _answerID = _radioGroup.getCheckedRadioButtonId();
        RadioButton _answerB= _radioGroup.findViewById(_answerID);
        Bundle bundle = new Bundle();
        bundle.putString("answer", _answerB.getText().toString());
        getParentFragmentManager().setFragmentResult("answerChoose", bundle);
    }

}