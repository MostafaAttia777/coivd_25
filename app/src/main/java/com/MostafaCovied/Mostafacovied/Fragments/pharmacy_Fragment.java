package com.MostafaCovied.Mostafacovied.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.Activity.Medical_Supplies;
import com.MostafaCovied.Mostafacovied.Adpters.Adpter_pharmcy;
import com.MostafaCovied.Mostafacovied.Models.Model_pharmcy;
import com.MostafaCovied.Mostafacovied.On_Item_Listener;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;


public class pharmacy_Fragment extends Fragment {

    private Adpter_pharmcy adpter_pharmcy;
    private ArrayList<Model_pharmcy> model_pharmcies;
    RecyclerView recyclerView_ph;
    Context context;
    On_Item_Listener on_item_listener =new On_Item_Listener() {
        @Override
        public void onItemClick(int position) {

       startActivity(new Intent(getActivity(), Medical_Supplies.class));

        }
    };




    public pharmacy_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_pharmacy_, container, false);
        recyclerView_ph = view.findViewById(R.id.recyclerView_pharmcy);
        model_pharmcies = new ArrayList<>();
        model_pharmcies.add(new Model_pharmcy(getString(R.string.pharmacy_mohamed_morad), getString(R.string.pharmacy_mohamed_morad_address), getString(R.string.pharmacy_mohamed_morad_phone),getString(R.string.pharmacy_mohamed_morad_phone_wh)));
        adpter_pharmcy = new Adpter_pharmcy(model_pharmcies,getActivity(), on_item_listener);
        recyclerView_ph.setAdapter(adpter_pharmcy);
        recyclerView_ph.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }


//    private void MedicalSupplies(int position) {
//
//    }
}
