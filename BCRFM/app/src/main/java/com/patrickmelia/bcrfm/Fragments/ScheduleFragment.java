package com.patrickmelia.bcrfm.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.patrickmelia.bcrfm.MainActivity;
import com.patrickmelia.bcrfm.R;

/**
 * Created by Patrick on 25/06/2015.
 */
public class ScheduleFragment extends Fragment {

    private RecyclerView mRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_schedule, container, false);

        ((MainActivity) getActivity()).setTitle(R.string.schedule);

        Toast.makeText(getActivity(), "Sorry we can't find any info at this time, please try again later.", Toast.LENGTH_LONG).show();

        //setHasOptionsMenu(true);

        return view;

    }

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }*/
}
