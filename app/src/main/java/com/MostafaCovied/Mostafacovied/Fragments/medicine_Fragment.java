package com.MostafaCovied.Mostafacovied.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.MostafaCovied.Mostafacovied.Adpters.Adpter_medicine;
import com.MostafaCovied.Mostafacovied.Models.Medicin_Model;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;
import java.util.Collections;


public class medicine_Fragment extends Fragment {

    RecyclerView recyclerView;
    Adpter_medicine adpter_medicine;
    ArrayList<Medicin_Model> medicin_models;
    androidx.appcompat.widget.SearchView searchView;
    Context context;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        context = getActivity();
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    public medicine_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine_, container, false);
        recyclerView = view.findViewById(R.id.medicine_recycler);
        medicin_models = new ArrayList<>();
        medicin_models.add(new Medicin_Model(getString(R.string.medicine_Rivarospire), getString(R.string.medicine_Rivarospire_des), 196, "https://www.adwyaa.com/assets/img/bg-img/rivarospireeda3.jpg"));
        medicin_models.add(new Medicin_Model(getString(R.string.medicine_Iverzine), getString(R.string.medicine_Iverzine_des), 15,"https://1.bp.blogspot.com/-evn9ksrKHck/XXKDJhDi-oI/AAAAAAAABsA/0BEL0nkgFBM9FdTaJFPrRRfwY1oqTnBxwCLcBGAs/s1600/Capture.JPG"));
        medicin_models.add(new Medicin_Model(getString(R.string.all_vent), getString(R.string.all_vent_des), 10, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoaa8dueK44u3rsH6BZvOG8qqC6jT_vfoLKQ&usqp=CAU"));
        medicin_models.add(new Medicin_Model(getString(R.string.ennervita), getString(R.string.ennervita_des), 27, "https://www.almazeyd.com/wp-content/uploads/Ennervita.jpg"));
        medicin_models.add(new Medicin_Model(getString(R.string.superx), getString(R.string.superx_des), 43, "https://souqaldawaa.com/wp-content/uploads/2019/02/Suprax.jpg"));
        medicin_models.add(new Medicin_Model(getString(R.string.Targo), getString(R.string.Targo_des), 40, "https://dalilaldwaa.com/data/medicine/3510.png"));
        medicin_models.add(new Medicin_Model(getString(R.string.Solupred), getString(R.string.Solupred_des), 41, "https://tabibby.com/wp-content/uploads/2020/04/%D8%B3%D9%88%D9%84%D8%A8%D8%B1%D9%8A%D8%AF-1.jpg"));

        adpter_medicine = new Adpter_medicine(medicin_models);
        recyclerView.setAdapter(adpter_medicine);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_ic_search, menu);
        final MenuItem menuItem = menu.findItem(R.id.my_filter_icon);
        searchView = (androidx.appcompat.widget.SearchView) menuItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);

                }
                menuItem.collapseActionView();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<Medicin_Model> data = filter(medicin_models, newText);
                adpter_medicine.setfilter(data);
                return true;
            }
        });




    }
    private ArrayList<Medicin_Model> filter(ArrayList<Medicin_Model> p1, String query) {

        query = query.toLowerCase();
        final ArrayList<Medicin_Model> filterformodel = new ArrayList<>();
        for (Medicin_Model medicin_model : p1) {
            final String text = medicin_model.getMed_name().toLowerCase();
            if (text.startsWith(query)) {
                filterformodel.addAll(Collections.singleton(medicin_model));
            }

        }
        return filterformodel;
    }
}
