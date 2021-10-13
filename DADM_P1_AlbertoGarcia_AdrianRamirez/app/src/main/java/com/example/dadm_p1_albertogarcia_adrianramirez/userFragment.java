package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.content.Intent;
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

    String playerName;
    Integer score;

    //layout references
    TextView scoreView;
    TextView playerNameView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //creation of object that receives data from gameFragment
        getParentFragmentManager().setFragmentResultListener("answerPass", this, (requestKey, bundle) -> {
            boolean result = bundle.getBoolean("answer");
            if (result){
                score+=10;
                scoreView.setText(score.toString());
            }
        });

        getParentFragmentManager().setFragmentResultListener("finished", this, (requestKey, bundle) -> {
            Intent intent = new Intent(getActivity(), ScoreActivity.class);
            intent.putExtra("playerName", playerName);
            intent.putExtra("score", score.toString());

            getActivity().startActivity(intent);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.user_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        score = requireArguments().getInt("initialScore");
        playerName=  requireArguments().getString("playerName");

        //we reference the elements of the layout
        scoreView = view.findViewById(R.id.score);
        playerNameView = view.findViewById(R.id.playerName);

        scoreView.setText(score.toString());
        playerNameView.setText(playerName);
    }
}