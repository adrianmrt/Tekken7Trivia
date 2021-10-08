package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout _nickLayout;
    private EditText _nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _nick = findViewById(R.id.nickInput);
        _nickLayout = findViewById(R.id.nickInputLayout);
    }

    @Override
    protected void onResume() {
        super.onResume();

        _nickLayout.setErrorEnabled(false);
    }

    public void play(View v){
        if(TextUtils.isEmpty(_nick.getText().toString())){
            _nickLayout.setError("Campo vacío");
            _nickLayout.setErrorEnabled(true);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("nick", _nick.getText().toString());

            Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
            startActivity(intent);
        }
    }
}