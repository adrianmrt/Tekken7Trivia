package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout _playerNameLayout;
    private EditText _playerName;
    QuestionStructure[]_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _playerName = findViewById(R.id.playerNameInput);
        _playerNameLayout = findViewById(R.id.playerNameInputLayout);
        _questions= createQuestions();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    protected void onResume() {
        super.onResume();

        _playerNameLayout.setErrorEnabled(false);
    }

    public void play(View v){
        if(TextUtils.isEmpty(_playerName.getText().toString())){
            _playerNameLayout.setError("Campo vacío");
            _playerNameLayout.setErrorEnabled(true);
        } else {
            Intent intent = new Intent(getApplicationContext(),QuestionActivity.class);

            intent.putExtra("playerName", _playerName.getText().toString());
            intent.putExtra("questions",_questions);
            startActivity(intent);
        }
    }

    public QuestionStructure[] createQuestions(){
        QuestionStructure[] questionAux = new QuestionStructure[2];
        questionAux[0]=new QuestionStructure(0,1,"Answer1");
        questionAux[1]= new QuestionStructure(1,0,"Answer1");
        return questionAux;
    }
}