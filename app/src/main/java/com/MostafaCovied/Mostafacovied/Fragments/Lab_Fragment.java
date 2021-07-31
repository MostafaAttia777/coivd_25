package com.MostafaCovied.Mostafacovied.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.MostafaCovied.Mostafacovied.Activity.Abd_Lab;
import com.MostafaCovied.Mostafacovied.Adpters.Adpter_lab;
import com.MostafaCovied.Mostafacovied.Models.Lab_Model;
import com.MostafaCovied.Mostafacovied.On_Item_Listener;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;


public class Lab_Fragment extends Fragment {

    Adpter_lab adpter_lab_;
    RecyclerView recyclerView;

    ArrayList<Lab_Model> arrayList;

    On_Item_Listener on_item_listener=new On_Item_Listener() {
        @Override
        public void onItemClick(int position) {
      startActivity(new Intent(getActivity(), Abd_Lab.class));

        }
    };
    public Lab_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_lab_, container, false);
        recyclerView = view.findViewById(R.id.rec_lab);

        arrayList = new ArrayList<>();

        arrayList.add(new Lab_Model(getString(R.string.lab_Abdel_Naby), getString(R.string.lab_Abdel_Naby_address), getString(R.string.lab_Abdel_Naby_phone), getString(R.string.lab_Abdel_Naby_phone_wh)));
        adpter_lab_ = new Adpter_lab(getActivity(),on_item_listener,arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adpter_lab_);
        return view;
    }

}
