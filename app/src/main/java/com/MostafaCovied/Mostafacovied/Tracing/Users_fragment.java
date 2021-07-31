package com.MostafaCovied.Mostafacovied.Tracing;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.MostafaCovied.Mostafacovied.Ministry.Healthy_model;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class Users_fragment extends Fragment {
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    Adpter_of_live_tracing live_tracing;
    ArrayList<Healthy_model> healthy_models = new ArrayList<>();
    List<Healthy_model> list = new ArrayList<>();
    String user_id;
    //    double longitude;
//    double latitude;
    String o_id;

    public Users_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_users_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_of_live_trcaing);

        firebaseFirestore.collection("Users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (queryDocumentSnapshots != null) {
                    list.clear();
                    for (final DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Healthy_model healthy_model = snapshot.toObject(Healthy_model.class);
                        final String name = healthy_model.getName();
                        user_id = String.valueOf(snapshot.get("user_id"));
                        String image_link = String.valueOf(snapshot.get("image_link"));
                        double Longitude = healthy_model.getLongitude();
                        double Latitude = healthy_model.getLatitude();
//                        final double accuracy =  healthy_model.getAccuracy();
//                        double elapsedRealtimeNanos =  healthy_model.getElapsedRealtimeNanos();
//                        final double speed =  healthy_model.getSpeed();
//                        final double time =  healthy_model.getTime();
                        // Toast.makeText(Health_of_egypt.this, time+""+speed+"", Toast.LENGTH_SHORT).show();
                        //  Toast.makeText(Health_of_egypt.this, Longitude+""+Latitude, Toast.LENGTH_SHORT).show();
                        list.add(new Healthy_model(name, user_id, Latitude, Longitude, image_link));
                        // list.add(new Healthy_model(name,user_id,Latitude,Longitude,image_link,accuracy,elapsedRealtimeNanos,speed,time));
                        live_tracing = new Adpter_of_live_tracing((ArrayList<Healthy_model>) list, new OnclickListner() {
                            @Override
                            public void onItemClick(int position) {
                                Intent intent_go_to_maps = new Intent(getActivity(), live_tracting.class);
                                Bundle bundle = new Bundle();
                                bundle.putDouble("latitude", list.get(position).getLatitude());
                                bundle.putDouble("longitude", list.get(position).getLongitude());
                                bundle.putString("user_id", list.get(position).getId());
                                bundle.putString("user_name", list.get(position).getName());
//                                bundle.putString("accuracy", String.valueOf(list.get(position).getAccuracy()));
//                                bundle.putString("elapsedRealtimeNanos", String.valueOf(list.get(position).getElapsedRealtimeNanos()));
//                                bundle.putString("speed", String.valueOf(list.get(position).getSpeed()));
//                                bundle.putString("time", String.valueOf(list.get(position).getTime()));
                                // intent_go_to_maps.putExtra("user_data", String.valueOf(list));
                                intent_go_to_maps.putExtras(bundle);
                                startActivity(intent_go_to_maps);
                            }
                        });
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recyclerView.setAdapter(live_tracing);
                    }

                }
            }
        });
        return view;
    }
}
