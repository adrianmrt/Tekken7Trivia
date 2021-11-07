package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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
    String UserList = "";
    DatabaseViewModel databaseViewModel;

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

        userNameLayout = view.findViewById(R.id.addUserNameLayout);
        usersListText = view.findViewById(R.id.usersListText);
        userName = view.findViewById(R.id.addUserName);
        addUser = view.findViewById(R.id.addUserButton);

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
            if (TextUtils.isEmpty(userName.getText().toString())) {
                userNameLayout.setError("Campo vacío");
                userNameLayout.setErrorEnabled(true);
            } else {
                Utils utils = new Utils();
                User user = new User();
                user.setName(userName.getText().toString());
                databaseViewModel.InsertUser(user);
                Toast.makeText(getActivity(), "User added", Toast.LENGTH_SHORT).show();
                userName.setText("");
            }
        });

        return view;
    }
}