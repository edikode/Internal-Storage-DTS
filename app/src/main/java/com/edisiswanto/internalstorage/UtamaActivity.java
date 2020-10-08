package com.edisiswanto.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UtamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);
    }

    public void activityInternalStorage(View view) {
        Intent activityInternalStorage = new Intent(UtamaActivity.this, InternalStorageActivity.class);
        startActivity(activityInternalStorage);
    }

    public void activityExternalStorage(View view) {
        Intent activityExternalStorage = new Intent(UtamaActivity.this, ExternalStorageActivity.class);
        startActivity(activityExternalStorage);
    }

    public void activitySharedReference(View view) {
        Intent activitySharedReference = new Intent(UtamaActivity.this, SharedReferencesActivity.class);
        startActivity(activitySharedReference);
    }
}