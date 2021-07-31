package com.MostafaCovied.Mostafacovied.Adpters;

import android.app.Dialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.Models.Model_supplies;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class Adpter_for_supplies extends RecyclerView.Adapter<Adpter_for_supplies.vh_for_supplies> {

    ArrayList<Model_supplies> supplies;
    Dialog dialog;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("pharmacy_sales");
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    String id_order;
    public Adpter_for_supplies(ArrayList<Model_supplies> supplies) {
        this.supplies = supplies;
    }

    @NonNull
    @Override
    public vh_for_supplies onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_supplies, parent, false);
        vh_for_supplies vh_for_supplies = new vh_for_supplies(view);
        return vh_for_supplies;
    }

    @Override
    public void onBindViewHolder(@NonNull vh_for_supplies holder, int position) {
        final Model_supplies model_supplies = supplies.get(position);
        holder.textView_name.setText(model_supplies.getSupp_name());
        holder.textView_price.setText(model_supplies.getSupp_price() + "");
//        holder.imageView.setImageResource(model_supplies.getSupp_image());
        Picasso.get().load(model_supplies.getSupp_image()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                        firebaseFirestore.collection("pharmacy_sales").addSnapshotListener(new EventListener<QuerySnapshot>() {
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
                dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.custome_dialog);
                final TextView name_tx = (TextView) dialog.findViewById(R.id.name_dialog);
                // final TextView price_tx = (TextView) dialog.findViewById(R.id.price_onlyy);
                final EditText count_medicine = (EditText) dialog.findViewById(R.id.cont_medicine);
                ImageView imageViews = (ImageView) dialog.findViewById(R.id.custome_di);
                Button button_okay = (Button) dialog.findViewById(R.id.okay);
                Button button_cancel = (Button) dialog.findViewById(R.id.no_cancel);
                name_tx.setText(model_supplies.getSupp_name());
                Picasso.get().load(model_supplies.getSupp_image()).into(imageViews);
                final String id = firebaseUser.getUid();
                button_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        final String count = count_medicine.getText().toString();
                        String order_id = String.valueOf(System.currentTimeMillis());
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("order_id", order_id);
                        hashMap.put("user_id", id);
                        hashMap.put("med_name", model_supplies.getSupp_name());
                        hashMap.put("med_price", model_supplies.getSupp_price());
                        hashMap.put("count", count);
                        Integer price = Integer.parseInt(String.valueOf(model_supplies.getSupp_price()));
                        Integer counter_ = Integer.parseInt(count);
                        int mult = price * counter_;
                        hashMap.put("mult", mult);
                        hashMap.put("med_image", String.valueOf(model_supplies.getSupp_image()));
//                        databaseReference.child(id).child(model_supplies.getSupp_name()).setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(v.getContext(), "Added to cart", Toast.LENGTH_SHORT).show();
//                                    dialog.cancel();
//                                } else {
//                                    String error_message = task.getException().getLocalizedMessage();
//                                    Log.i("error", error_message);
//                                }
//                            }
//                        });
                        firebaseFirestore.collection("pharmacy_sales").document(order_id).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(v.getContext(), "Added to cart", Toast.LENGTH_SHORT).show();
                                    dialog.cancel();
                                } else {
                                    String error_message = task.getException().getLocalizedMessage();
                                    Log.i("error", error_message);
                                }
                            }
                        });
                    }
                });
                button_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return supplies.size();
    }

    class vh_for_supplies extends RecyclerView.ViewHolder {
        TextView textView_name, textView_price;
        ImageView imageView;

        public vh_for_supplies(@NonNull View itemView) {
            super(itemView);
            textView_name = itemView.findViewById(R.id.sup_name);
            textView_price = itemView.findViewById(R.id.sup_price);
            imageView = itemView.findViewById(R.id.sup_iamges);
        }
    }
}
