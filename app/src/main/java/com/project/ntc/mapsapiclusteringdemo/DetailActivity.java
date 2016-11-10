package com.project.ntc.mapsapiclusteringdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.project.ntc.mapsapiclusteringdemo.MapsActivity.items;

public class DetailActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private ImageView imageView;
    private LinearLayout activityDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        String id_po = getIntent().getStringExtra("id_po");
        if (id_po == null) {
            finish();
        } else {
            String id = null;
            double lat = 0;
            double lng = 0;
            String title = null;
            String desc = null;
            String images = null;
            for (Items item : items) {
                if (item.getId().equals(id_po)) {
                    id = item.getId();
                    lat = item.getLat();
                    lng = item.getLng();
                    title = item.getTitle();
                    desc = item.getDesc();
                    images = item.getImages();
                    break;
                }
            }
            textView.setText("ID: " + id);
            textView2.setText("LatLng: " + lat + " - " + lng);
            textView3.setText("Title: " + title);
            textView4.setText("Desc: " + desc);

            Picasso.with(this).load(images).noFade().into(imageView);
        }
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        imageView = (ImageView) findViewById(R.id.imageView);
        activityDetail = (LinearLayout) findViewById(R.id.activity_detail);
    }
}
