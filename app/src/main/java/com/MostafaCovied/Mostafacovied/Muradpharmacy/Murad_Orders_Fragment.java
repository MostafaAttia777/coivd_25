package com.MostafaCovied.Mostafacovied.Muradpharmacy;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class Murad_Orders_Fragment extends Fragment {
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    Adpter_for_pharmacy adpter_for_pharmacy;
    ArrayList<Murad_Pharmacy_Modle> muradPharmacyModles = new ArrayList<>();
    List<Murad_Pharmacy_Modle> list = new ArrayList<>();
    String user_id;

    public Murad_Orders_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_orders_, container, false);
        recyclerView = view.findViewById(R.id.rc_orders);
      //  firebaseAuth.signOut();
        firebaseFirestore.collection("Confirm_medication_reservation").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                list.clear();
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
//                    Murad_Pharmacy_Modle modle = snapshot.toObject(Murad_Pharmacy_Modle.class);
//                    final String user_id = modle.getUser_id();
//                    String user_phone = modle.getCustomer_phone();
//                    String user_sign = modle.getCustomer_sign();
//                    String user_address = modle.getCustomer_address();
//                    String user_name = modle.getCustomer_name();
//                    String user_order_id = modle.getOrder_id();
//                    String total_price = modle.getTotal_price();
                    //    list.add(new Murad_Pharmacy_Modle(user_name, user_phone, user_address, user_sign, user_order_id, user_id));
                  //  list.add(new Murad_Pharmacy_Modle(user_address, user_name, user_sign, user_phone,user_id,total_price));
                   String user_address= String.valueOf(snapshot.get("customer_address"));
                   String user_name= String.valueOf(snapshot.get("customer_name"));
                   String user_phone= String.valueOf(snapshot.get("customer_phone"));
                   String user_sign= String.valueOf(snapshot.get("customer_sign"));
                   String total_price= String.valueOf(snapshot.get("total_price"));
                   String user_id= String.valueOf(snapshot.get("user_id"));
                    list.add(new Murad_Pharmacy_Modle(user_address, user_name, user_sign, user_phone,user_id,total_price));
                    adpter_for_pharmacy = new Adpter_for_pharmacy((ArrayList<Murad_Pharmacy_Modle>) list, new OnclickListner() {
                        @Override
                        public void onItemClick(int position) {
                            Intent intent_go_to_show_users_orders = new Intent(getActivity(), Show_orders_of_users_ph.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("user_id",list.get(position).getUser_id());
                            bundle.putString("total_price",list.get(position).getTotal_price());
                            intent_go_to_show_users_orders.putExtras(bundle);
                            view.getContext().startActivity(intent_go_to_show_users_orders);

                        }
                    });
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adpter_for_pharmacy);
            }
        });

        return view;

    }
}
