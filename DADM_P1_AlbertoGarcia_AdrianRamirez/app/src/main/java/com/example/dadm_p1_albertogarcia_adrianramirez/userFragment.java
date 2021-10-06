package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class userFragment extends Fragment {

    Integer points;
    String playerName;

    //layout references
    TextView scoreV;
    TextView playerNameV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //creation of object that receives data from gameFragment
        getParentFragmentManager().setFragmentResultListener("answerPass", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                boolean result = bundle.getBoolean("answer");
                if (result==true){
                    points++;
                    scoreV.setText(points.toString());
                }

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.user_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        points= requireArguments().getInt("initialPoints");
        playerName=  requireArguments().getString("playerName");

        //we reference the elements of the layout
        scoreV= view.findViewById(R.id.score);
        playerNameV= view.findViewById(R.id.playerName);
        

        scoreV.setText(points.toString());
        playerNameV.setText(playerName);


    }
}