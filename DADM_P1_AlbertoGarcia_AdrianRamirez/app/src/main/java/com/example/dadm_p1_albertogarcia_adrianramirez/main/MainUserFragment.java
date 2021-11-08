package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.Question;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.User;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class MainUserFragment extends Fragment {

    TextInputLayout userNameLayout;
    TextView usersListText;
    EditText userName;
    Button addUser;
    Button deleteUser;
    Button selectUser;
    Button changeToAnonym;
    String UserList = "";
    DatabaseViewModel databaseViewModel;
    Utils utils;
    boolean added;
    Handler handler;
    SharedPreferences sharedPreferences;

    public MainUserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseViewModel = new ViewModelProvider(getActivity()).get(DatabaseViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_user, container, false);
        handler= new Handler();
        utils = new Utils();
        sharedPreferences= getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        userNameLayout = view.findViewById(R.id.addUserNameLayout);
        usersListText = view.findViewById(R.id.usersListText);
        userName = view.findViewById(R.id.addUserName);
        addUser = view.findViewById(R.id.addUserButton);
        //AÑADIR BOTONES

        databaseViewModel.getAllUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                UserList = "";
                for (User u : users) {
                    String name = u.getName();
                    UserList = UserList + "Nombre: " + name + "\n\n";
                }
                usersListText.setText(UserList);
            }
        });

        addUser.setOnClickListener(v -> {
            added=false;
            if (TextUtils.isEmpty(userName.getText().toString())) {
                userNameLayout.setError("Campo vacío");
                userNameLayout.setErrorEnabled(true);
            } else {
                Runnable r= new Runnable() {
                    @Override
                    public void run() {
                        if(added) {
                            Toast.makeText(getActivity(), "User added", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getActivity(), "User already exists", Toast.LENGTH_SHORT).show();
                        }
                        userName.setText("");
                    }
                };
                Thread t= new Thread(){
                    @Override
                    public void run() {
                        User userAux=databaseViewModel.GetUser(userName.getText().toString());
                        if (userAux== null) {
                            User user = new User();
                            user.setName(userName.getText().toString());
                            user.setMaxScore(0);
                            user.setNumberOfGamesPlayed(0);
                            databaseViewModel.InsertUser(user);
                            added=true;
                        }else{
                            added=false;
                        }
                        handler.post(r);
                    }
                };
                t.start();
            }
        });

        /*
        deleteUser.setOnClickListener(v -> {
            databaseViewModel.DeleteUser(userName.getText().toString());
        });


        selectUser.setOnClickListener(v -> {
            sharedPreferences.edit().putString("User",userName.getText().toString()).commit();
            sharedPreferences.edit().putBoolean("UserMode",true).commit();
        });

        changeToAnonym.setOnClickListener(v -> {
            sharedPreferences.edit().putBoolean("UserMode",false).commit();
        });

         */




        return view;
    }
}