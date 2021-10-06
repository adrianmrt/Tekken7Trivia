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

    int points;
    //layout references
    TextView pointsV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        points=0;

        //creation of object that receives data from gameFragment
        getParentFragmentManager().setFragmentResultListener("answerPass", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                boolean result = bundle.getBoolean("answer");
                if (result==true){
                    points++;
                    pointsV.setText(points);
                }

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.user_fragment, container, false);
        pointsV = root.findViewById(R.id.score);
        pointsV.setText(points);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}