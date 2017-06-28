package com.example.android.listviewbekraf.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.listviewbekraf.DetailActivity;
import com.example.android.listviewbekraf.R;
import com.example.android.listviewbekraf.pojo.Orang;
import com.tapadoo.alerter.Alerter;

/**
 * Created by DITHA on 19/06/2017.
 */

public class OrangViewHolder extends RecyclerView.ViewHolder{

    private TextView nama;
    private TextView pekerjaan;
    private ImageView img;

    public OrangViewHolder(View itemView){
        super(itemView);

        nama = (TextView) itemView.findViewById(R.id.tvNama);
        pekerjaan = (TextView) itemView.findViewById(R.id.tvJobs);
        img = (ImageView) itemView.findViewById(R.id.img);
    }

    public void bind(final Orang data, final Activity activity){
        nama.setText(data.getNama());
        pekerjaan.setText(data.getPekerjaan());
        Glide.with(itemView.getContext()).load(data.getImgURL()).into(img);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerter.create(activity)
                        .setTitle(data.getNama())
                        .setText(data.getPekerjaan())
                        .show();
                Intent in = new Intent(itemView.getContext(), DetailActivity.class);
                in.putExtra("orang", data);
                /*
                in.putExtra("img", data.getImgURL());
                in.putExtra("nama", data.getNama());
                in.putExtra("pekerjaan", data.getPekerjaan());
                */
                itemView.getContext().startActivity(in);

            }
        });
    }

}
