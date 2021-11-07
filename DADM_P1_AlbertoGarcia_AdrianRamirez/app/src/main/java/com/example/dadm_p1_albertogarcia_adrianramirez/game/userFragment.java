package com.example.dadm_p1_albertogarcia_adrianramirez.game;

import android.content.Intent;
import android.os.AsyncTask;
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


public class userFragment extends Fragment {

    String playerName;
    Integer score;

    //layout references
    TextView scoreView;
    TextView playerNameView;
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
        //creation of object that receives data from gameFragment
        getParentFragmentManager().setFragmentResultListener("answerPass", this, (requestKey, bundle) -> {
            boolean result = bundle.getBoolean("answer");
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
            String _time= Integer.toString(min)+"."+Integer.toString(sec);
            intent.putExtra("time", _time);
            getActivity().startActivity(intent);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        _questions = bundle.getParcelableArray("questions");
        return inflater.inflate(R.layout.user_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        score = requireArguments().getInt("initialScore");
        playerName = requireArguments().getString("playerName");

        //we reference the elements of the layout
        scoreView = view.findViewById(R.id.score);
        playerNameView = view.findViewById(R.id.playerName);

        scoreView.setText(score.toString());
        playerNameView.setText(playerName);

        timer = view.findViewById(R.id.timer);
<<<<<<< HEAD:DADM_P1_AlbertoGarcia_AdrianRamirez/app/src/main/java/com/example/dadm_p1_albertogarcia_adrianramirez/game/UserFragment.java
=======
        time = Integer.toString(min) + "min " + Integer.toString(sec) + "s";
        timer.setText(time);
>>>>>>> parent of 3183c79 (Merge pull request #37 from adrianmrt/Alberto):DADM_P1_AlbertoGarcia_AdrianRamirez/app/src/main/java/com/example/dadm_p1_albertogarcia_adrianramirez/game/userFragment.java

        t = new Timer();
        t.scheduleAtFixedRate(
                new TimerTask() {
                    public void run() {
                        startTimer();
                    }
                },
                0,      // run first occurrence immediatetly
                1000); // run every x seconds
    }


<<<<<<< HEAD:DADM_P1_AlbertoGarcia_AdrianRamirez/app/src/main/java/com/example/dadm_p1_albertogarcia_adrianramirez/game/UserFragment.java
    public String startTimer() {
        time = Integer.toString(min) + "m " + Integer.toString(sec) + "s";
=======
    public void startTimer() {
        time = Integer.toString(min) + "min " + Integer.toString(sec) + "s";
>>>>>>> parent of 3183c79 (Merge pull request #37 from adrianmrt/Alberto):DADM_P1_AlbertoGarcia_AdrianRamirez/app/src/main/java/com/example/dadm_p1_albertogarcia_adrianramirez/game/userFragment.java
        timer.setText(time);
        sec++;
        if (sec == 60) {
            min++;
            sec = 0;
        }
    }
}
