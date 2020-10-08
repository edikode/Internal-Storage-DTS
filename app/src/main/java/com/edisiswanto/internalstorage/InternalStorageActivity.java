package com.edisiswanto.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity {

    public static final String FILENAME = "namafile.txt";
    Button btnBuatFile, btnBacaFile, btnUbahFile, btnHapusFile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        btnBuatFile = findViewById(R.id.btnBuatFile);
        btnBacaFile = findViewById(R.id.btnBacaFile);
        btnUbahFile = findViewById(R.id.btnUbahFile);
        btnHapusFile = findViewById(R.id.btnHapusFile);

        textBaca = findViewById(R.id.textBaca);

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
        File file = new File(getFilesDir(), FILENAME);

        if(file.exists()) {
            file.delete();

            textBaca.setText("File berhasil dihapus");
        }

    }


    private void bacaFile() {
        File file = new File(getFilesDir(), FILENAME);

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

    private void buatFile() {
        // File ini akan tersimpan pada: data/data/com.edisiswanto.internalstorage
        // Buka di Device File Explorer: menu View > Tool Windows > Device Explorer

        String isiFile = "Ini adalah isi dari file ini \n";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}