package com.vickonovianto.itbexplorer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainPortraitFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MainPortraitFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;

    public MainPortraitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_portrait, container, false);
    }

}
