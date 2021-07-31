package com.MostafaCovied.Mostafacovied.Ministry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.MostafaCovied.Mostafacovied.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cases_fragment extends Fragment {

    public Cases_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cases_fragment, container, false);
    }
}
