package com.example.android.listviewbekraf.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.listviewbekraf.R;
import com.example.android.listviewbekraf.pojo.Orang;
import com.example.android.listviewbekraf.viewholder.OrangViewHolder;

import java.util.List;

/**
 * Created by DITHA on 19/06/2017.
 */

public class OrangAdapter extends RecyclerView.Adapter<OrangViewHolder>{

    private List<Orang> list;
    private Activity activity;

    public OrangAdapter(List<Orang> list, Activity activity){
        this.list = list;
        this.activity = activity;
    }

    @Override
    public OrangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_cardview, parent, false);
        return new OrangViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(OrangViewHolder holder, int position) {
        holder.bind(list.get(position), activity);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
