package com.example.goko3210.tabbarpager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by goko3210 on 16/5/10.
 */
public class User {
    private Bitmap portrait;
    private String name;
    private String motto;
    private String portraitString;

    public User()
    {
        this.portrait=null;
        this.name="";
        this.motto="";
        this.portraitString="";
    }

    public User(String motto, String name, Bitmap portrait) {
        this.motto = motto;
        this.name = name;
        this.portrait = portrait;
        portraitString=encodeToBase64(this.portrait, Bitmap.CompressFormat.PNG,100);
    }

    public String getPortraitString() {
        return portraitString;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getPortrait() {
        return portrait;
    }

    public void setPortrait(Bitmap portrait) {
        this.portrait = portrait;
    }

    public void setPortraitString(String portraitString) {
        this.portraitString = portraitString;
        this.portrait = decodeBase64(this.portraitString);
    }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

}
