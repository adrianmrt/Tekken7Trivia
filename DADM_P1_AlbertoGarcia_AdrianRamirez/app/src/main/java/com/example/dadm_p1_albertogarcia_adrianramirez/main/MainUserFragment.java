package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.User;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class MainUserFragment extends Fragment {

    TextInputLayout userNameLayout;
    TextView usersListText;
    EditText userName;
    Button addUser;

    List<User> usersList;

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

        userNameLayout = view.findViewById(R.id.addUserNameLayout);
        usersListText = view.findViewById(R.id.usersListText);
        userName = view.findViewById(R.id.addUserName);
        addUser = view.findViewById(R.id.addUserButton);

        addUser.setOnClickListener(v -> {
            String usersListInfo = null;

            if (TextUtils.isEmpty(userName.getText().toString())) {
                userNameLayout.setError("Campo vacío");
                userNameLayout.setErrorEnabled(true);
            } else {
                User user = new User();
                user.setName(userName.getText().toString());

                MainActivity.userDataBase.userDAO().addUser(user);
                Toast.makeText(getActivity(), "User added", Toast.LENGTH_SHORT).show();

                usersList = MainActivity.userDataBase.userDAO().getUsers();

                for (User users : usersList){
                    String name = user.getName();

                    usersListInfo = "Nombre: " + name + "\n\n";
                }

                usersListText.setText(usersListInfo);
                userName.setText("");
            }
        });

        return view;
    }
}