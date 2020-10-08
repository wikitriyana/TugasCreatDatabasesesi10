package com.wiki.buatdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DbHelper dbHelper;
    Button  btnStore, tampil;
    EditText etname;

    TextView tvnames;
    private ArrayList <String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DbHelper(this);

        dbHelper = new DbHelper (this);
        tvnames = (TextView) findViewById (R.id.tvnames);

        btnStore =  findViewById (R.id.btnstore);
        tampil =  findViewById (R.id.tampil);
        etname = (EditText) findViewById (R.id.etname);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.addStudentDetail (etname.getText (). toString ());
                etname.setText ("");
                Toast.makeText (MainActivity.this, "Berhasil Tersimpan!", Toast.LENGTH_SHORT) .show ();
            }
        });

        tampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = dbHelper.getAllStudentsList();
                tvnames.setText("");
                for (int i = 0; i < arrayList.size(); i++) {
                    tvnames.setText(tvnames.getText().toString() + ", " + arrayList.get(i));
                }
            }
        });


    }

}
