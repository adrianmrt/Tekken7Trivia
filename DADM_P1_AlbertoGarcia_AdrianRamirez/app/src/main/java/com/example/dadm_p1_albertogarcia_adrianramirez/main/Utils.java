package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {

    Context context;

    public Utils(Context c) {
        context = c;
    }

    public Utils(){};

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

    //Files management
    public void OpenOutFile(String filename, String dataToSave) {
        try {
            FileOutputStream fos= context.openFileOutput(filename,Context.MODE_APPEND);
            String cadenaOutput = dataToSave;
            fos.write(cadenaOutput.getBytes());
            fos.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String OpenInFile(String filename) {
        try {
            FileInputStream fin = context.openFileInput(filename);
            DataInputStream dis = new DataInputStream(fin);
            String cadenaInput = dis.readLine();
            fin.close();
            return cadenaInput;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
