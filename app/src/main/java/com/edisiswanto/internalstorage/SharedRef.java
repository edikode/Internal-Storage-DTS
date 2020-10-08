package com.edisiswanto.internalstorage;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedRef {
    SharedPreferences SharedRef;

    public SharedRef(Context context) {
        SharedRef = context.getSharedPreferences("myRef", Context.MODE_PRIVATE);
    }

    public void SaveData(String Username, String Password) {
        SharedPreferences.Editor editor = SharedRef.edit();
        editor.putString("Username", Username);
        editor.putString("Password", Password);
        editor.commit();
    }

    public String LoadData() {
        String FileContent = "Username: "+ SharedRef.getString("Username", "No Name");
        FileContent += "  === Password: "+ SharedRef.getString("Password", "No Password");

        return FileContent;
    }
}


