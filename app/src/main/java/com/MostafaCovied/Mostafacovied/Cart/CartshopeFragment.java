package com.MostafaCovied.Mostafacovied.Cart;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.MostafaCovied.Mostafacovied.Models.Medicin_Model;
import com.MostafaCovied.Mostafacovied.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;


public class CartshopeFragment extends Fragment {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    ArrayList<Medicin_Model> medicin;
    ArrayList<Medicin_Model> medicin_models = new ArrayList<>();
    Adpter_get_data_from_db getDataFromDb;
    RecyclerView recyclerView;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    String mult;
    int temp = 0;
    String price;

    TextView textView;
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    String id = firebaseUser.getUid();
    Button button_confarim;
    String id_order;
    String total;
    String med_image;
    String med_name;
    String count;
    List<Medicin_Model> list = new ArrayList<>();
//    OnclickListner listner = new OnclickListner() {
//        @Override
//        public void onItemClick(final int position) {
//
//           deleteing(position);
//            Toast.makeText(getActivity(), position+"", Toast.LENGTH_SHORT).show();
//        }
//    };
//
//    private void deleteing(final int position) {
//        firebaseFirestore.collection("pharmacy_sales").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    String uid = String.valueOf(task.getResult().getDocuments().get(position).get("order_id"));
//                    Toast.makeText(getActivity(), uid, Toast.LENGTH_SHORT).show();
//                    firebaseFirestore.collection("pharmacy_sales").document(uid).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()) {
//                                Toast.makeText(getActivity(), "deleted", Toast.LENGTH_SHORT).show();
//                                synchronized (firebaseFirestore) {
//                                    firebaseFirestore.notifyAll();
//                                    firebaseFirestore.notify();
//
//                                } } }
//                    }); } }
//        });
//    }

    public CartshopeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View view = inflater.inflate(R.layout.fragment_cartshope, container, false);
        recyclerView = view.findViewById(R.id.car_recycler);
        textView = view.findViewById(R.id.my_toatly);
        button_confarim = view.findViewById(R.id.confirm_buy_medicin);
//        firebaseFirestore.collection("pharmacy_sales").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
//
//                for (DocumentSnapshot snapshot:queryDocumentSnapshots.getDocuments()){
//
//                    id_order=snapshot.getId();
//
//                }
//            }
//        });
        String user_id = firebaseUser.getUid();
        firebaseFirestore.collection("pharmacy_sales").whereEqualTo("user_id", user_id).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                medicin_models.clear();
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    med_name = String.valueOf(snapshot.get("med_name"));
                    count = String.valueOf(snapshot.get("count"));
                    //  Integer mult = Integer.parseInt(String.valueOf(snapshot.get("mult")));
                    total = String.valueOf(snapshot.get("mult"));
                    // Toast.makeText(view.getContext(), mult+"", Toast.LENGTH_SHORT).show();
                    med_image = String.valueOf(snapshot.get("med_image"));
                    // list.add(new Medicin_Model(med_name,med_image,count,total));
                    medicin_models.add(new Medicin_Model(med_name, med_image, count, total));
                    list.add(new Medicin_Model(med_name, med_image, count, total));
                    temp += Integer.parseInt(total);
                    textView.setText(temp + "");
                    getDataFromDb = new Adpter_get_data_from_db(medicin_models);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(getDataFromDb);
                    recyclerView.setHasFixedSize(true);
                    getDataFromDb.notifyDataSetChanged();
                }
            }
        });
//        firebaseFirestore.collection("pharmacy_sales").document(id_order).addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                if (queryDocumentSnapshots != null) {
//                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
//
//                        String med_name = String.valueOf(snapshot.get("med_name"));
//                        String count = String.valueOf(snapshot.get("count"));
//                        //  Integer mult = Integer.parseInt(String.valueOf(snapshot.get("mult")));
//                        String total = String.valueOf(snapshot.get("mult"));
//                        // Toast.makeText(view.getContext(), mult+"", Toast.LENGTH_SHORT).show();
//                        String med_image = String.valueOf(snapshot.get("med_image"));
//                        medicin_models.add(new Medicin_Model(med_name, med_image, count, total));
//                        temp += Integer.parseInt(total);
//                        textView.setText(temp + "");
//                        // Toast.makeText(view.getContext(), temp + "", Toast.LENGTH_SHORT).show();
//                        getDataFromDb = new Adpter_get_data_from_db(medicin_models);
//                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//                        recyclerView.setAdapter(getDataFromDb);
//                        recyclerView.setHasFixedSize(true);
//                    }
//
//                }
//            }
//        });
        //        firebaseFirestore.collection("pharmacy_sales").document(id_order).addSnapshotListener(new EventListener<DocumentSnapshot>() {
        //            @Override
        //            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
        //
        //                String med_name = String.valueOf(documentSnapshot.get("med_name"));
        //                String count = String.valueOf(documentSnapshot.get("count"));
        //                String med_image = String.valueOf(documentSnapshot.get("med_image"));
        //                String total = String.valueOf(documentSnapshot.get("mult"));
        //                medicin_models.add(new Medicin_Model(med_name, med_image, count, total));
        //                temp += Integer.parseInt(total);
        //                textView.setText(temp + "");
        //                getDataFromDb = new Adpter_get_data_from_db(medicin_models);
        //                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //                recyclerView.setAdapter(getDataFromDb);
        //                recyclerView.setHasFixedSize(true);
        //            }
        //        });
        button_confarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(),confirm_order_medicin.class));
                Intent intent_go_to_confram_order = new Intent(getActivity(), confirm_order_medicin.class);
                Bundle bundle = new Bundle();
//                bundle.putString("count", count + "");
//                bundle.putString("med_name", medicin_models+"" );
                bundle.putString("total", temp + "");
//                bundle.putString("med_image", med_image+"");
                intent_go_to_confram_order.putExtras(bundle);
                recyclerView.removeAllViews();
                medicin_models.clear();
                view.getContext().startActivity(intent_go_to_confram_order);


            }
        });
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        })
        return view;
    }
}
