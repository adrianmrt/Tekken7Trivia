package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.dadm_p1_albertogarcia_adrianramirez.database.User;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainUserFragment extends Fragment {

    TextInputLayout userNameLayout;
    TextView usersListText;
    EditText userName;
    Button addUser;
    Button deleteUser;
    Button selectUser;
    Button updateUser;
    String userListStringToDelete = "";
    String currentDate;
    DatabaseViewModel databaseViewModel;
    Utils utils;
    boolean added;
    Handler handler;
    SharedPreferences sharedPreferences;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<UserCard> userCardArrayList = new ArrayList<>();

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

        handler = new Handler();
        utils = new Utils();

        //recyclerview
        recyclerView = view.findViewById(R.id.userCardRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        sharedPreferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        userNameLayout = view.findViewById(R.id.addUserNameLayout);
        userName = view.findViewById(R.id.addUserName);
        addUser = view.findViewById(R.id.addUserButton);
        deleteUser = view.findViewById(R.id.userCardDeleteImageButton);
        selectUser = view.findViewById(R.id.userCardPlayImageButton);
        updateUser = view.findViewById(R.id.userCardEditImageButton);

        databaseViewModel.getAllUsers().observe(getViewLifecycleOwner(), users -> {
            userCardArrayList.clear();
            for (User u : users) {
                userCardArrayList.add(new UserCard(u.getName(), u.getLastTimePlayed()));
            }
            adapter = new UserCardAdapter(userCardArrayList);
            recyclerView.setAdapter(adapter);
        });

        addUser.setOnClickListener(v -> {
            added = false;
            if (TextUtils.isEmpty(userName.getText().toString())) {
                userNameLayout.setError("Campo vacío");
                userNameLayout.setErrorEnabled(true);
            } else {
                Runnable r = () -> {
                    if (added) {
                        userCardArrayList.add(new UserCard(userName.getText().toString(), currentDate));
                        Toast.makeText(getActivity(), "User added", Toast.LENGTH_SHORT).show();
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new MainUserFragment()).addToBackStack(null).commit();
                    } else {
                        Toast.makeText(getActivity(), "User already exists", Toast.LENGTH_SHORT).show();
                    }
                    userName.setText("");
                };
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        User userAux = databaseViewModel.GetUser(userName.getText().toString());
                        if (userAux == null) {
                            Calendar calendar = Calendar.getInstance();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                            currentDate = dateFormat.format(calendar.getTime());
                            User user = new User();
                            user.setName(userName.getText().toString());
                            user.setMaxScore(0);
                            user.setNumberOfGamesPlayed(0);
                            user.setLastTimePlayed(currentDate);
                            databaseViewModel.InsertUser(user);
                            added = true;
                        } else {
                            added = false;
                        }
                        handler.post(r);
                    }
                };
                t.start();
            }
        });

        /*
        deleteUser.setOnClickListener(v -> {
            //IMPLEMENTAR EL BORRADO CON EL BOTÓN
            Toast.makeText(getActivity(), "BORRAR", Toast.LENGTH_SHORT).show();
            //databaseViewModel.DeleteUser("");
        });

        selectUser.setOnClickListener(v -> {
            //IMPLEMENTAR JUGAR CON EL BOTÓN
            Toast.makeText(getActivity(), "SELECCIONAR", Toast.LENGTH_SHORT).show();
            //sharedPreferences.edit().putString("User", userName.getText().toString()).commit();
            //sharedPreferences.edit().putBoolean("UserMode", true).commit();
        });
         */

        return view;
    }
}