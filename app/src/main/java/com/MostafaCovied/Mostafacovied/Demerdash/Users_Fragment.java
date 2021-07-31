package com.MostafaCovied.Mostafacovied.Demerdash;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
public class Users_Fragment extends Fragment {
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    List<Dem_modle> dem_modles=new ArrayList<>();
Adpter_dem adpter_dem;
    public Users_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_users_, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_dem);
        firebaseFirestore.collection("Hospital_Confirm_reservation").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                dem_modles.clear();
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
                    String patient_address= String.valueOf(snapshot.get("patient_address"));
                    String patient_name= String.valueOf(snapshot.get("patient_name"));
                    String patient_phone= String.valueOf(snapshot.get("patient_phone"));
                    String patient_age= String.valueOf(snapshot.get("patient_age"));
                    String total_price= String.valueOf(snapshot.get("total_price"));
                    String user_id= String.valueOf(snapshot.get("user_id"));
                    dem_modles.add(new Dem_modle(patient_address,patient_name,patient_phone,user_id));
                    adpter_dem = new Adpter_dem((ArrayList<Dem_modle>) dem_modles, new OnclickListner() {
                        @Override
                        public void onItemClick(int position) {
                            Intent intent_go_to_show_book_room=new Intent(getActivity(),Show_book_room.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("user_id",dem_modles.get(position).getUser_id());
                            intent_go_to_show_book_room.putExtras(bundle);
                            view.getContext().startActivity(intent_go_to_show_book_room);
                        }
                    });
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adpter_dem);
            }
        });
        return view;
    }
}
