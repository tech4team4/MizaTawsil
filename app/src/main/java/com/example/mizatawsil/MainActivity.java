package com.example.mizatawsil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference magasinRef = db.collection("Nom_Magasin");
    private magasinAdapter adapter;
    private RecyclerView mFirestoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirestoreList = findViewById(R.id.recycler_view_magasin);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query query = magasinRef.orderBy("nom", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<magasin> options = new FirestoreRecyclerOptions.Builder<magasin>()
                .setQuery(query, magasin.class)
                .build();
        adapter = new magasinAdapter(options);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_magasin);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListner(new magasinAdapter.OnItemClickListner() {
            @Override
            public void OnItemClick(DocumentSnapshot documentSnapshot, int position) {

            }

            @Override
            public void onItemLongClick(DocumentSnapshot documentSnapshot, int position, View v) {

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
