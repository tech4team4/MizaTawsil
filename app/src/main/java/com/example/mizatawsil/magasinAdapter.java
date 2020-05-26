package com.example.mizatawsil;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class magasinAdapter extends RecyclerView.Adapter<magasinAdapter.magasinHolder> {
    private Context mContext;
    private ArrayList<magasin> magasinList;

    public magasinAdapter(Context context, ArrayList<magasin> magasinList) {
        this.mContext = context;
        this.magasinList = magasinList;
    }


    @Override
    public void onBindViewHolder(@NonNull magasinHolder holder, int position) {
        //magasin uploadCurrent = mUploads.get(position);
        holder.nom_magasin.setText(magasinList.get(position).getName());

        Picasso.get().
                load(magasinList.get(position).getImageURL())
                //.into(holder.imageView);
                .placeholder(R.drawable.bg1)
                .fit()
                //.centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return magasinList.size();
    }


    @Override
    public magasinAdapter.magasinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_magasin, parent, false);
        return new magasinHolder(view);
    }


    class magasinHolder extends RecyclerView.ViewHolder {
        TextView nom_magasin;
        ImageView imageView;

        public magasinHolder(@NonNull View itemView) {
            super(itemView);
            nom_magasin = itemView.findViewById(R.id.text_view_magasin);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


}
