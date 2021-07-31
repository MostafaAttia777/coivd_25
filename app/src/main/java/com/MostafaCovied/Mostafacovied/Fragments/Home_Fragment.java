package com.MostafaCovied.Mostafacovied.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.MostafaCovied.Mostafacovied.Adpters.Adptar_Syptomes;
import com.MostafaCovied.Mostafacovied.Adpters.Adptar_Syptomes_prv;
import com.MostafaCovied.Mostafacovied.Models.Model_home;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {
    Button button;
    Adptar_Syptomes adptar_syptomes;
    Adptar_Syptomes_prv adptar_syptomes_prev;
    RecyclerView recyclerView;
    RecyclerView recyclerView_rev;
    ArrayList<Model_home> model_homes;
    ArrayList<Model_home> model_homes_prev;

    public Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_home_, container, false);
//        button =view.findViewById(R.id.outer);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//                firebaseAuth.signOut();
//                startActivity(new Intent(view.getContext(), LoginScreen.class));
//            }
//        });
//
//https://www.behance.net/mustafaattia


        recyclerView = view.findViewById(R.id.rec_home_page);
        recyclerView_rev = view.findViewById(R.id.rec_home_page_Prevention);
        model_homes = new ArrayList<>();
        model_homes.add(new Model_home(R.drawable.c1, getString(R.string.cough)));
        model_homes.add(new Model_home(R.drawable.s1, getString(R.string.sneezing)));
        model_homes.add(new Model_home(R.drawable.migraine, getString(R.string.headache)));
        model_homes.add(new Model_home(R.drawable.soreethroat, getString(R.string.sore_throat)));
        model_homes.add(new Model_home(R.drawable.tiredness, getString(R.string.tiredness)));
        model_homes.add(new Model_home(R.drawable.f1, getString(R.string.fever)));
        adptar_syptomes = new Adptar_Syptomes(model_homes);
        recyclerView.setAdapter(adptar_syptomes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        model_homes_prev = new ArrayList<>();

        model_homes_prev.add(new Model_home(R.drawable.nohandshake,getString(R.string.one)));

        model_homes_prev.add(new Model_home(R.drawable.mask, getString(R.string.three)));
        model_homes_prev.add(new Model_home(R.drawable.washinghands, getString(R.string.two)));
        adptar_syptomes_prev = new Adptar_Syptomes_prv(model_homes_prev);
        recyclerView_rev.setAdapter(adptar_syptomes_prev);
        recyclerView_rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        context.getApplicationContext();


    }
}
