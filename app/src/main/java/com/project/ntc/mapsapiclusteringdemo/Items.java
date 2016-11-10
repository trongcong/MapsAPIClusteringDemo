package com.project.ntc.mapsapiclusteringdemo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * IDE: Android Studio
 * Created by Nguyen Trong Cong  - 2DEV4U.COM
 * Name packge: com.project.ntc.mapsapiclusteringdemo
 * Name project: MapsAPIClusteringDemo
 * Date: 11/11/2016
 * Time: 4:51 AM
 */

public class Items implements ClusterItem {
    private final LatLng mPosition;
    private String id;
    private double lat;
    private double lng;
    private String title;
    private String desc;
    private String images;

    public Items(String id, double lat, double lng, String title, String desc, String images) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.title = title;
        this.desc = desc;
        this.images = images;

        mPosition = new LatLng(lat, lng);
    }

    public LatLng getPosition() {
        return mPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
