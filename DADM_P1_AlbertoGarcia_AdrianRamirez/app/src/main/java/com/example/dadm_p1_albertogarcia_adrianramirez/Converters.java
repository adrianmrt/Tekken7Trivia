package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

class Converters {

    //tansforms a bitmap to string for being JSONinfied
    public byte[] fromBitmapToBytes(Bitmap bitmap) {
        ByteArrayOutputStream out= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,out);
        return out.toByteArray();
    }

    public Bitmap fromBytesToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }

    @TypeConverter
    public String fromListToJSON(ArrayList<Bitmap> list){
        ArrayList<byte[]>byteList= new ArrayList<>();
        for(int i=0;i<list.size();i++){
            byteList.add(fromBitmapToBytes(list.get(i)));
        }
        return new Gson().toJson(byteList);
    }

    @TypeConverter
    public ArrayList<Bitmap> fromJSONToList(String s){
        ArrayList<byte[]>list= new Gson().fromJson(s,new TypeToken<ArrayList<Byte[]>>(){}.getType());
        ArrayList<Bitmap>bitmapList= new ArrayList<>();
        for(int i=0;i<list.size();i++){
            bitmapList.add(fromBytesToBitmap(list.get(i)));
        }
        return  bitmapList;
    }

    @TypeConverter
    public String fromStringListToJSON(ArrayList<String> list){
        return new Gson().toJson(list);
    }

    @TypeConverter
    public ArrayList<String> fromJSONToStringList(String s){
        ArrayList<String>list= new Gson().fromJson(s,new TypeToken<ArrayList<String>>(){}.getType());
        return list;
    }
}
