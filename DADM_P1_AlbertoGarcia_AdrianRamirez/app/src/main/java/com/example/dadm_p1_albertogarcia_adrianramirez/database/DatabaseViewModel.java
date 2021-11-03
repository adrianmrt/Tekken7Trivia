package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DatabaseViewModel extends AndroidViewModel {

    LiveData<List<Question>> readAllData;

    public DatabaseViewModel(@NonNull Application application) {
        super(application);
    }

}
