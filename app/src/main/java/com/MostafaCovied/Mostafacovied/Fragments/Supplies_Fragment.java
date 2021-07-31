package com.MostafaCovied.Mostafacovied.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.MostafaCovied.Mostafacovied.Adpters.Adpter_for_supplies;
import com.MostafaCovied.Mostafacovied.Models.Medicin_Model;
import com.MostafaCovied.Mostafacovied.Models.Model_pharmcy;
import com.MostafaCovied.Mostafacovied.Models.Model_supplies;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;


public class Supplies_Fragment extends Fragment {

    Adpter_for_supplies adpter_for_supplies;
    RecyclerView recyclerView;
    ArrayList<Model_supplies> supplies;
    ArrayList<Medicin_Model> pharmcies;

    public Supplies_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_supplies_, container, false);
        recyclerView = view.findViewById(R.id.supplies_frages);
        supplies = new ArrayList<>();

        supplies.add(new Model_supplies(getString(R.string.Mask), 3, "https://png.pngtree.com/png-clipart/20200323/ourmid/pngtree-medical-mask-surgical-mask-n95-mask-for-coronavirus-png-image_2164083.jpg"));
        supplies.add(new Model_supplies(getString(R.string.faceprotection), 10, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTYixzBDBksKrBy65WLIgL1yZ66BsS1Bclbw&usqp=CAU"));
        supplies.add(new Model_supplies(getString(R.string.glovestion), 5, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbexXNAsnTlGA3xNeiTGH-Qqx-JITMKNdiJw&usqp=CAU"));

        supplies.add(new Model_supplies(getString(R.string.sanitizer), 15, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZ1AC3JiFirLG3Ncx1KnJW1uDrAtwXD_N3aw&usqp=CAU"));

     //   pharmcies.add(new Medicin_Model(getString(R.string.sanitizer), 15, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZ1AC3JiFirLG3Ncx1KnJW1uDrAtwXD_N3aw&usqp=CAU")))

        adpter_for_supplies = new Adpter_for_supplies(supplies);

        recyclerView.setAdapter(adpter_for_supplies);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        return view;

    }
}
