package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class NumbAdapter extends RecyclerView.Adapter<NumbViewHolder> {
   List<NumbModel> data= DataSource.getInstance().getRemoteData();
    public void insert(NumbModel newMod)
    {
        data.add(newMod);
        notifyItemInserted(data.size()-1);
    }
    @NonNull
    @Override
    public NumbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.numb_item,parent, false);
       return new NumbViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbViewHolder holder, int position) {
NumbModel model =data.get(position);
holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
