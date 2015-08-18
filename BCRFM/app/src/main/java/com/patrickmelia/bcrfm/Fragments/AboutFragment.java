package com.patrickmelia.bcrfm.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.patrickmelia.bcrfm.MainActivity;
import com.patrickmelia.bcrfm.R;

/**
 * Created by Patrick on 25/06/2015.
 */
public class AboutFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_about, container, false);

        ((MainActivity) getActivity()).setTitle(R.string.about);

        return view;
    }
}
