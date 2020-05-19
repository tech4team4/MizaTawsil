package com.example.mizatawsil;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class magasinAdapter extends FirestoreRecyclerAdapter<magasin, magasinAdapter.magasinHolder> {

    public magasinAdapter(@NonNull FirestoreRecyclerOptions<magasin> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull magasinHolder holder, int position, @NonNull magasin model) {
        holder.nom_magasin.setText(model.getNom());
    }

    @NonNull
    @Override
    public magasinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_magasin, parent, false);
        return new magasinHolder(v);
    }

    class magasinHolder extends RecyclerView.ViewHolder {
        TextView nom_magasin;

        public magasinHolder(@NonNull View itemView) {
            super(itemView);
            nom_magasin = itemView.findViewById(R.id.text_view_magasin);

            /////ce code pour click listner list
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listner != null) {
                        listner.OnItemClick(getSnapshots().getSnapshot(position), position);
                    }
                }
            });
            ///
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    listner.onItemLongClick(getSnapshots().getSnapshot(position), getAdapterPosition(), v);
                    return true;
                }
            });


        }
    }

    //////ce code pour clicker sur list
    public interface OnItemClickListner {
        void OnItemClick(DocumentSnapshot documentSnapshot, int position);

        void onItemLongClick(DocumentSnapshot documentSnapshot, int position, View v);
    }

    private OnItemClickListner listner;

    public void setOnItemClickListner(OnItemClickListner listner) {
        this.listner = listner;
    }
}
