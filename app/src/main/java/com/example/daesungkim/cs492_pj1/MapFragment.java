package com.example.daesungkim.cs492_pj1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MapFragment extends Fragment {
    Button mMapButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_map, container, false);

        Button mMapButton = (Button) rootview.findViewById(R.id.mapbutton);
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent i = new Intent(getContext(), MapActivity.class);
                startActivity(i);
            }
        });

        // Inflate the layout for this fragment
        return rootview;
    }
}
