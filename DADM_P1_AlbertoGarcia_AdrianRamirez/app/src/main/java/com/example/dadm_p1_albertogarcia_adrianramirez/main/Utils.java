package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Utils {

    public static ArrayList createBitmapList(int[] elements, Context context) {
        ArrayList<Bitmap> list = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            list.add(BitmapFactory.decodeResource(context.getResources(), elements[i]));
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
