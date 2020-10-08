package com.edisiswanto.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExternalStorageActivity extends AppCompatActivity {

    public static final String FILENAME = "namafile.txt";
    Button btnBuatFile, btnBacaFile, btnUbahFile, btnHapusFile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        btnBuatFile = findViewById(R.id.btnBuatFile);
        btnBacaFile = findViewById(R.id.btnReadFile);
        btnUbahFile = findViewById(R.id.btnUpdateFile);
        btnHapusFile = findViewById(R.id.btnDeleteFile);

        textBaca = findViewById(R.id.textRead);

        btnBuatFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buatFile();
            }
        });

        btnBacaFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bacaFile();
            }
        });

        btnHapusFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusFile();
            }
        });
    }

    private void hapusFile() {
        String state = Environment.getExternalStorageState();

        if(!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), FILENAME);

        if(file.exists()) {
            file.delete();
            textBaca.setText("File berhasil dihapus");
        }
    }

    private void buatFile() {
        // File ini akan tersimpan pada: sdcard/Android/data/com.edisiswanto.internalstorage
        // Buka di Device File Explorer: menu View > Tool Windows > Device Explorer

        String isiFile = "Isi data dari external storage \n";
        String state = Environment.getExternalStorageState();

        if(!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();

            Toast toast = Toast.makeText(getApplicationContext(), "Data berhasil dibuat", Toast.LENGTH_LONG);
            toast.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void bacaFile() {
        String state = Environment.getExternalStorageState();

        if(!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), FILENAME);

        if(file.exists()) {

            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();

                while(line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            textBaca.setText(text.toString());

        }
    }

}