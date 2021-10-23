package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;

@Database(entities = {QuestionStructure2.class}, version = 1)
@TypeConverters(Converters.class)

public abstract class AppDatabase extends RoomDatabase {
    private static Context _context;

    public abstract QuestionDao questionDao();
    private static volatile AppDatabase INSTANCE;

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            _context= context;
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final QuestionDao qDao;

        PopulateDbAsync(AppDatabase db) {
            qDao = db.questionDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            startDataBase(qDao);
            return null;
        }
    }


    public static void startDataBase(QuestionDao qDao) {

        QuestionStructure2 q1= new QuestionStructure2(1,0, 0, createBitmapList(new int[]{}),
                "Miguel", "¿Qué personaje es español?",
                createStringList(new String[]{"Lidia", "Miguel", "Leo"}));

        qDao.Insert(q1);

        QuestionStructure2 q2= new QuestionStructure2(2,0, 1, createBitmapList(new int[]{R.drawable.devilkazuya_img_round, R.drawable.devilkazumi_img_round, R.drawable.deviljin_img_round}),
                "Kazumi", "¿Qué personaje no es de sangre Mishima?",
                createStringList(new String[]{"Kazuya", "Kazumi", "Jin"}));

        qDao.Insert(q2);

        QuestionStructure2 q3= new QuestionStructure2(3,0, 1, createBitmapList(new int[]{R.drawable.alisa_img_round, R.drawable.kuma_img_round, R.drawable.king_img_round}),
                "King", "¿Quién es humano?",
                createStringList(new String[]{"Alisa", "Kuma II", "King"}));

        qDao.Insert(q3);

        QuestionStructure2 q4= new QuestionStructure2(4,1, 0, createBitmapList(new int[]{R.drawable.steve_img_round}),
                "Steve", "¿Cómo se llama este personaje?",
                createStringList(new String[]{"Steve", "Lars", "Dragunov"}));

        qDao.Insert(q4);

        QuestionStructure2 q5= new QuestionStructure2(5,0, 1, createBitmapList(new int[]{0, R.drawable.akuma_img_round, R.drawable.julia_img_round, R.drawable.fahkumram_img_round}),
                "Akuma", "¿Qué personaje no pertenece originalmente a la saga Tekken?",
                createStringList(new String[]{"Akuma", "Julia", "Fahkumram"}));

        qDao.Insert(q5);
    }

    public static ArrayList createBitmapList(int[] elements) {
        ArrayList<Bitmap> list = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            list.add(BitmapFactory.decodeResource(_context.getResources(), elements[i]));
        }
        return list;
    }

    public static ArrayList createStringList(String[] elements) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
        return list;
    }
}
