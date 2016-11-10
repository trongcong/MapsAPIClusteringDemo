package com.project.ntc.mapsapiclusteringdemo;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import java.util.HashMap;

/**
 * IDE: Android Studio
 * Created by Nguyen Trong Cong  - 2DEV4U.COM
 * Name packge: com.project.ntc.mapsapiclusteringdemo
 * Name project: MapsAPIClusteringDemo
 * Date: 11/11/2016
 * Time: 4:54 AM
 */

public class PersonRenderer extends DefaultClusterRenderer<Items> {
    Context context;
    GoogleMap map;
    ClusterManager<Items> clusterManager;
    Marker itemsMarkerCache = null;
    private HashMap<String, Uri> images = null;

    public PersonRenderer(Context context, GoogleMap map, ClusterManager<Items> clusterManager, HashMap<String, Uri> images) {
        super(context, map, clusterManager);
        this.context = context;
        this.map = map;
        this.clusterManager = clusterManager;
        this.images = images;
    }

    @Override
    protected void onClusterItemRendered(Items items, Marker marker) {
        super.onClusterItemRendered(items, marker);
        try {
            // Set id send Intent
            marker.setTag("setId= " + items.getId());
            images.put(marker.getId(), Uri.parse(items.getImages()));
            Log.d("maker ", "images - " + marker.getId().toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onBeforeClusterItemRendered(Items items, MarkerOptions markerOptions) {
        markerOptions.position(new LatLng(items.getLat(), items.getLng())).title(items.getTitle()).snippet(items.getDesc());
    }

    @Override
    protected boolean shouldRenderAsCluster(Cluster<Items> cluster) {
        return cluster.getSize() > 2;
    }
}
