package com.MostafaCovied.Mostafacovied.Abd_Lab_admin;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.MostafaCovied.Mostafacovied.Confiram_Lab_model;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

/**
 * A simple {@link Fragment} subclass.
 */
public class Users_orders_lab extends Fragment {
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    Adpter_Lab_for_users Adpter_Lab_for_users;
    ArrayList<Confiram_Lab_model> confiram_lab_models = new ArrayList<>();
  List<Confiram_Lab_model> list = new ArrayList<>();
    String user_id;
    public Users_orders_lab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_users_orders_lab, container, false);
        recyclerView=view.findViewById(R.id.rc_scan_lab);

        firebaseFirestore.collection("Lab_Confirm_reservation").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                list.clear();
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    Confiram_Lab_model modle = snapshot.toObject(Confiram_Lab_model.class);
                    String user_name = modle.getPatient_name();
                    String user_phone = modle.getPatient_phone();
                    String user_age = modle.getPatient_age();
                    String user_id = modle.getUser_id();

                    //    list.add(new Murad_Pharmacy_Modle(user_name, user_phone, user_address, user_sign, user_order_id, user_id));
                    list.add(new Confiram_Lab_model(user_age,user_name,user_phone,user_id));
                    Adpter_Lab_for_users = new Adpter_Lab_for_users((ArrayList<Confiram_Lab_model>) list, new OnclickListner() {
                        @Override
                        public void onItemClick(int position) {
                            Intent intent_go_to_show_users_orders = new Intent(getActivity(), Show_orders_of_users_Lab.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("user_id",list.get(position).getUser_id());
                            intent_go_to_show_users_orders.putExtras(bundle);
                            view.getContext().startActivity(intent_go_to_show_users_orders);

                        }
                    });
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(Adpter_Lab_for_users);
            }
        });
        return view;

    }
}
