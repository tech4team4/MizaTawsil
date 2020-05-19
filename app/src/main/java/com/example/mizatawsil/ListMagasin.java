package com.example.mizatawsil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ListMagasin extends AppCompatActivity {
    TextView nomMag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_magasin);
        nomMag=findViewById(R.id.title_textView_Categ);

    }
}
