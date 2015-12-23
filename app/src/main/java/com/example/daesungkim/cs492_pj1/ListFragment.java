package com.example.daesungkim.cs492_pj1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import org.json.*;



/**
 * Created by daeseongkim on 2015. 11. 29..
 */
public class ListFragment extends Fragment {
    ListView _listView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        _listView = (ListView)rootView.findViewById(R.id.listView);
        get_list();

        return rootView;
    }

    public void get_list () {
        ArrayList<String> list = new ArrayList<String>();
        list.clear();
        list.add("1st");
        list.add("2nd");
        list.add("3rd");
        ListAdapter adapter = new ListAdapter(getActivity(), list, getResources());
        _listView.setAdapter(adapter);
    }
}

