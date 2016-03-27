package com.vickonovianto.itbexplorer;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainPortraitFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MainPortraitFragment extends Fragment implements OnMapReadyCallback {

    //private OnFragmentInteractionListener mListener;
    private FragmentActivity fa;

    public MainPortraitFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fa = new FragmentActivity();
        SupportMapFragment mapFragment = (SupportMapFragment) fa.getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return inflater.inflate(R.layout.fragment_main_portrait, container, false);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
    }

}
