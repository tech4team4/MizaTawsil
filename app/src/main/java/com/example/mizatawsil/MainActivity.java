package com.example.mizatawsil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private StorageReference mStorageRef;
    private RecyclerView recyclerView;
    private ArrayList<magasin> magasinsList;
    private Context context = MainActivity.this;
    private magasinAdapter magasinAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_magasin);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        magasinsList = new ArrayList<>();
        init();
    }


    private void init() {
        clearAll();
        DatabaseReference query =reference.child("uploads");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot :dataSnapshot.getChildren()){
                    magasin magasin=new magasin();
                    magasin.setImageURL(snapshot.child("imageURL").getValue().toString());
                    magasin.setName(snapshot.child("name").getValue().toString());
                    magasinsList.add(magasin);
                }
                magasinAdapter=new magasinAdapter(context,magasinsList);
                recyclerView.setAdapter(magasinAdapter);
                magasinAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void clearAll() {
        if (magasinsList != null) {
            magasinsList.clear();
            if(magasinAdapter!=null){
                magasinAdapter.notifyDataSetChanged();
            }
        }

        magasinsList=new ArrayList<>();
    }

}
