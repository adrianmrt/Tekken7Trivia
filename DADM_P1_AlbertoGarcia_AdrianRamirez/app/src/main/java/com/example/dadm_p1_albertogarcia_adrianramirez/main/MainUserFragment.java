package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.User;

public class MainUserFragment extends Fragment {
    EditText userName;
    Button addUser;

    public MainUserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_user, container, false);

        userName = view.findViewById(R.id.addUserName);
        addUser = view.findViewById(R.id.addUserButton);

        addUser.setOnClickListener(v -> {
            new Thread(() -> {
                User user = new User();
                user.setName(userName.getText().toString());
                MainActivity.userDataBase.userDAO().addUser(user);
            }).start();

            Toast.makeText(getActivity(), "User added", Toast.LENGTH_SHORT).show();

            userName.setText("");
        });

        return view;
    }
}