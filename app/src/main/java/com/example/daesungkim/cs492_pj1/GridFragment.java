package com.example.daesungkim.cs492_pj1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import java.util.ArrayList;

import org.json.*;
import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by daeseongkim on 2015. 11. 29..
 */
public class GridFragment extends Fragment {
    GridView _gridView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_grid, container, false);
        _gridView = (GridView)rootView.findViewById(R.id.gridView);

        get_grid();

        return rootView;
    }

    public void get_grid () {
        ArrayList<ImageObject> list = new ArrayList<>();
        list.clear();

        Integer dil[] = {R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6,
                R.drawable.image7,
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image10,
                R.drawable.image11,
                R.drawable.image12,
                R.drawable.image13,
                R.drawable.image14,
                R.drawable.image15
        };

        for (int i=1; i<16; i++) {
            ImageObject io = new ImageObject(dil[i-1], "image" + i);
            list.add(io);
        }

        GridAdapter adapter = new GridAdapter(getActivity(), list, getResources());
        _gridView.setAdapter(adapter);
    }
}

