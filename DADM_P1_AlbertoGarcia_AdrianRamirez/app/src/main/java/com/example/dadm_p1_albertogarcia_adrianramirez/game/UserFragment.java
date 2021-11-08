package com.example.dadm_p1_albertogarcia_adrianramirez.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;

import java.util.Timer;
import java.util.TimerTask;

public class UserFragment extends Fragment {

    String playerName;
    Integer score;
    Integer questionsQuantity;

    //layout references
    TextView scoreView;
    TextView playerNameView;
    TextView questionsQuantityView;
    Parcelable[] _questions;

    //timer elements
    Timer t;
    boolean finished;
    TextView timer;
    int sec, min, mili = 0;
    String time;
    Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        finished = false;
        time = "";
        handler = new Handler();

        //creation of object that receives data from GameFragment
        getParentFragmentManager().setFragmentResultListener("answerPass", this, (requestKey, bundle) -> {
            boolean result = bundle.getBoolean("answer");
            int count = bundle.getInt("count");
            questionsQuantityView.setText(count + "/" + questionsQuantity.toString());
            if (result) {
                score += 10;
                scoreView.setText(score.toString());
            }
        });

        getParentFragmentManager().setFragmentResultListener("finished", this, (requestKey, bundle) -> {
            finished = true;
            Intent intent = new Intent(getActivity(), ScoreActivity.class);
            intent.putExtra("playerName", playerName);
            intent.putExtra("score", score.toString());
            intent.putExtra("questions", _questions);
            intent.putExtra("timeT", time);
            String _time = Integer.toString(min) + "." + Integer.toString(sec);
            intent.putExtra("time", _time);
            getActivity().startActivity(intent);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle bundle = getArguments();
        _questions = bundle.getParcelableArray("questions");
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        questionsQuantity = sharedPreferences.getInt("numberOfQuestions", 5);

        score = requireArguments().getInt("initialScore");
        playerName = requireArguments().getString("playerName");

        //we reference the elements of the layout
        scoreView = view.findViewById(R.id.score);
        playerNameView = view.findViewById(R.id.playerName);
        questionsQuantityView = view.findViewById(R.id.textViewRoundCounter);

        scoreView.setText(score.toString());
        playerNameView.setText(playerName);
        questionsQuantityView.setText("0/" + questionsQuantity.toString());

        timer = view.findViewById(R.id.timer);

        t = new Timer();
        t.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        startTimer();
                    }
                },
                0,      // run first occurrence immediatetly
                1000); // run every x seconds
    }


    public void startTimer() {
        time = Integer.toString(min) + "m " + Integer.toString(sec) + "s";
        handler.post(myRunnable);
        sec++;
        if (sec == 60) {
            min++;
            sec = 0;
        }
    }

    final Runnable myRunnable = new Runnable() {
        public void run() {
            timer.setText(time);
        }
    };
}