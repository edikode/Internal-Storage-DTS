package com.edisiswanto.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SharedReferencesActivity extends AppCompatActivity {

    SharedRef sharedRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_references);

        sharedRef = new SharedRef(this);
    }

    public void dataSave(View view) {
        EditText inputUsername = findViewById(R.id.inputUsername);
        EditText inputPassword = findViewById(R.id.inputPassword);

        sharedRef.SaveData(inputUsername.getText().toString(), inputPassword.getText().toString());

    }

    public void dataUpdate(View view) {

    }

    public void dataLoad(View view) {
        String data = sharedRef.LoadData();
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
    }
}