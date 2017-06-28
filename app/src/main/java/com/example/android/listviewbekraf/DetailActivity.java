package com.example.android.listviewbekraf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.listviewbekraf.pojo.Orang;

import static com.example.android.listviewbekraf.R.id.img;

/**
 * Created by DITHA on 21/06/2017.
 */

public class DetailActivity extends AppCompatActivity {

    private ImageView IMG;
    private TextView TV_NAMA;
    private TextView TV_JOBS;

    private Orang person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        IMG = (ImageView) findViewById(img);
        TV_NAMA = (TextView) findViewById(R.id.tvNama);
        TV_JOBS = (TextView) findViewById(R.id.tvJob);

        if (getIntent() != null){
            /*
            String nama = getIntent().getStringExtra("nama");
            String pekerjaan = getIntent().getStringExtra("pekerjaan");
            String img = getIntent().getStringExtra("img");
            */

            person = (Orang) getIntent().getSerializableExtra("orang");

            /*
            Glide.with(this).load(img).into(IMG);
            TV_NAMA.setText(nama);
            TV_JOBS.setText(pekerjaan);
            */

            Glide.with(this).load(person.getImgURL()).into(IMG);
            TV_NAMA.setText(person.getNama());
            TV_JOBS.setText(person.getPekerjaan());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
