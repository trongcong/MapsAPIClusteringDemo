package com.project.ntc.mapsapiclusteringdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback,
        ClusterManager.OnClusterClickListener<Items>,
        ClusterManager.OnClusterItemClickListener<Items>,
        ClusterManager.OnClusterItemInfoWindowClickListener<Items> {

    public static List<Items> items;
    private GoogleMap mMap;
    private ClusterManager<Items> mClusterManager;
    private HashMap<String, Uri> images = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        AddItems();

        mClusterManager = new ClusterManager<>(this, mMap);
        mClusterManager.setRenderer(new PersonRenderer(getApplicationContext(), mMap, mClusterManager, images));
        mClusterManager.getMarkerCollection().setOnInfoWindowAdapter(new PopupInfoWindowAdapter(this, LayoutInflater.from(this), images));
        mClusterManager.setOnClusterClickListener(this);
        mClusterManager.setOnClusterItemClickListener(this);
        mClusterManager.setOnClusterItemInfoWindowClickListener(this);
        mClusterManager.addItems(items);
        mClusterManager.cluster();

        mMap.setInfoWindowAdapter(mClusterManager.getMarkerManager());
        mMap.setOnCameraIdleListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        mMap.setOnInfoWindowClickListener(mClusterManager);

        Log.d("po", mMap.getCameraPosition().target.toString());
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(16.054013633817473, 108.18356830626728), 12));

    }

    private void AddItems() {
        items = new ArrayList<>();
        items.add(new Items("1", 16.052694217029064, 108.21569614112377, "Title 1", "Des 1", "http://i0.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comBan-o-trinh-nao.jpg"));
        items.add(new Items("2", 16.06276602707278, 108.20455424487591, "Title 2", "Des 2", "http://i2.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comDo-da-la-dinh-menh-cua-dev-roi.jpg"));
        items.add(new Items("3", 16.067374209609703, 108.18889483809471, "Title 3", "Des 3", "http://i1.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comSELECT-FROM-Chi-Dev-moi-hieu.jpg"));
        items.add(new Items("4", 16.058873329688986, 108.21758810430765, "Title 4", "Des 4", "http://i2.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4uTruyen-ngan-kinh-di-duoi-10-chu.jpg"));
        items.add(new Items("5", 16.04596006111417, 108.21317821741104, "Title 5", "Des 5", "http://i1.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comBien-win-thanh-mac.jpg"));
        items.add(new Items("6", 16.05604606630699, 108.21483481675386, "Title 6", "Des 6", "http://i0.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comLy-do-con-gai-luon-duoc-yeu.jpg"));
        items.add(new Items("7", 16.069619463818, 108.1674086675048, "Title 7", "Des 7", "http://i2.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comchuyen-thuong-ngay.jpg"));
        items.add(new Items("8", 16.023777946598994, 108.20921290665865, "Title 8", "Des 8", "http://i2.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comSu-tien-hoa-cua-ngon-ngu-lap-trinh.jpg"));
        items.add(new Items("9", 16.07145166783658, 108.149548843503, "Title 9", "Des 9", "http://i2.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comAngry-bird-phien-ban-bug.jpg"));
        items.add(new Items("10", 16.07150643717114, 108.149548843503, "Title 10", "Des 10", "http://i1.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comLy-do-comment-code.jpg"));
        items.add(new Items("11", 16.084022445300892, 108.15384272485971, "Title 11", "Des 11", "http://i1.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comDon-gian-de-hieu.jpg"));
        items.add(new Items("11", 16.06865454565006, 108.20348974317312, "Title 12", "Des 12", "http://i0.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comTinh-nang-moi-cua-bug.jpg"));
        items.add(new Items("11", 16.076149211040065, 108.18868059664966, "Title 13", "Des 13", "http://i1.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comTrai-tao-khac-biet.jpg"));
        items.add(new Items("11", 16.058322378949374, 108.16375449299812, "Title 14", "Des 14", "http://i0.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comIm-lang-la-vang.jpg"));
        items.add(new Items("11", 16.05188741915913, 108.16008355468512, "Title 15", "Des 15", "http://i1.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comBi-an-mai-mai-la-bi-an.jpg"));
        items.add(new Items("11", 16.054569107281107, 108.21397215127945, "Title 16", "Des 16", "http://i0.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comQuy-thoi-gian-cua-dev.jpg"));
        items.add(new Items("11", 16.05096591280079, 108.21450993418694, "Title 17", "Des 17", "http://i0.wp.com/2dev4u.com/wp-content/uploads/2016/05/2dev4u.comHoi-dap-phien-ban-dev.jpg"));
    }


    @Override
    public boolean onClusterClick(Cluster<Items> cluster) {
        String firstName = cluster.getItems().iterator().next().getTitle();
        Toast.makeText(this, cluster.getSize() + " (including " + firstName + ")", Toast.LENGTH_SHORT).show();

        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (ClusterItem item : cluster.getItems()) {
            builder.include(item.getPosition());
        }
        final LatLngBounds bounds = builder.build();
        try {
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean onClusterItemClick(Items item) {
        // Does nothing, but you could go into the user's profile page, for example.
        Snackbar.make(findViewById(R.id.myCoordinatorLayout), "2 onClusterItemClick(Items item)!!", Snackbar.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onClusterItemInfoWindowClick(Items item) {
        // Does nothing, but you could go into the user's profile page, for example.
        Snackbar.make(findViewById(R.id.myCoordinatorLayout), "3 onClusterItemInfoWindowClick(Items item)!!" + item.getTitle(), Snackbar.LENGTH_LONG).show();
        Toast.makeText(this, item.getId().toString(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("id_po", item.getId().toString());
        startActivity(intent);
    }

}
