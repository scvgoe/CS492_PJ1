package com.example.daesungkim.cs492_pj1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GridFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GridFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GridFragment extends Fragment {
    GridView _gridview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_grid, container, false);
        _gridview = (GridView) rootview.findViewById(R.id.gridView);

        get_list();

        return rootview;
    }

    public void get_list () {
        ArrayList<Uri> list = new ArrayList<>();
        list.clear();

        list.add(Uri.parse("file://mnt/sdcard/DCIM/CandyCam/IMG_20141003_144513.jpg"));
        list.add(Uri.parse("file://mnt/sdcard/DCIM/CandyCam/IMG_20141003_144518.jpg"));
        list.add(Uri.parse("file://mnt/sdcard/DCIM/CandyCam/IMG_20141003_144654.jpg"));
        list.add(Uri.parse("file://mnt/sdcard/DCIM/CandyCam/IMG_20141004_122519.jpg"));
        list.add(Uri.parse("file://mnt/sdcard/DCIM/CandyCam/IMG_20141004_122532.jpg"));
        list.add(Uri.parse("file://mnt/sdcard/DCIM/CandyCam/IMG_20141004_122542.jpg"));

        GridAdapter adapter = new GridAdapter(getActivity(), list, getResources());
        _gridview.setAdapter(adapter);
    }
}
