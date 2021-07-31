package com.MostafaCovied.Mostafacovied.Adpters;

import android.app.Dialog;
import android.net.Uri;
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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.MostafaCovied.Mostafacovied.Models.Medicin_Model;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

public class Adpter_medicine extends RecyclerView.Adapter<Adpter_medicine.Box_vh> {
    Dialog dialog;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("pharmacy_sales");
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    public Adpter_medicine(ArrayList<Medicin_Model> medicin_models) {
        this.medicin_models = medicin_models;
    }

    ArrayList<Medicin_Model> medicin_models;
    List<Medicin_Model> medicin=new ArrayList<>();

    @NonNull
    @Override
    public Box_vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_shape_medicine, parent, false);
        return new Box_vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Box_vh holder, int position) {

        final Medicin_Model medicin_model = medicin_models.get(position);

        holder.textView_price.setText(medicin_model.getMed_price() + "");
        holder.textView_descrbtion.setText(medicin_model.getMed_descraption());
        holder.textView_name.setText(medicin_model.getMed_name());
        //  holder.imageView.setImageURI(Uri.parse(medicin_model.getMed_image()));
        Picasso.get().load(medicin_model.getMed_image()).into(holder.imageView);

        holder.imageView_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.custome_dialog);
                final TextView name_tx = (TextView) dialog.findViewById(R.id.name_dialog);
                // final TextView price_tx = (TextView) dialog.findViewById(R.id.price_onlyy);
                final EditText count_medicine = (EditText) dialog.findViewById(R.id.cont_medicine);
                ImageView imageViews = (ImageView) dialog.findViewById(R.id.custome_di);
                Button button_okay = (Button) dialog.findViewById(R.id.okay);
                Button button_cancel = (Button) dialog.findViewById(R.id.no_cancel);
                name_tx.setText(medicin_model.getMed_name());
                Picasso.get().load(medicin_model.getMed_image()).into(imageViews);
                final String id = firebaseUser.getUid();
                button_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        final String count = count_medicine.getText().toString();
                        String order_id = String.valueOf(System.currentTimeMillis());
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("order_id", order_id);
                        hashMap.put("user_id", id);
                        hashMap.put("med_name", medicin_model.getMed_name());
                        hashMap.put("med_price", medicin_model.getMed_price());
                        hashMap.put("count", count);
                        Integer price = Integer.parseInt(String.valueOf(medicin_model.getMed_price()));
                        Integer counter_ = Integer.parseInt(count);
                        int mult = price * counter_;
                        hashMap.put("mult", mult);
                        hashMap.put("med_image", String.valueOf(medicin_model.getMed_image()));
//                        databaseReference.child(id).child(medicin_model.getMed_name()).setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
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
//                        firebaseFirestore.collection("pharmacy_sales").addSnapshotListener(new EventListener<QuerySnapshot>() {
//                            @Override
//                            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
//
//                                if (e!=null){
//                                    Toast.makeText(v.getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                                for (DocumentChange snapshot:queryDocumentSnapshots.getDocumentChanges()){
//                                    Medicin_Model model=snapshot.getDocument().toObject(Medicin_Model.class);
//                                    medicin.add(model);
//                                    Log.i("enent",model.toString());
//                                    Log.i("enent", String.valueOf(medicin.size()));
//
//                                }
//                            }
//                        });
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
        return medicin_models.size();
    }

    class Box_vh extends RecyclerView.ViewHolder {
        TextView textView_name, textView_descrbtion, textView_price;
        ImageView imageView;
        ImageView imageView_cart;

        public Box_vh(@NonNull View itemView) {
            super(itemView);
            textView_price = itemView.findViewById(R.id.mec_price);
            textView_descrbtion = itemView.findViewById(R.id.mec_dec);
            textView_name = itemView.findViewById(R.id.mec_name);
            imageView = itemView.findViewById(R.id.mec_image);
            imageView_cart = itemView.findViewById(R.id.mec_cart);
        }
    }
    public void setfilter(ArrayList<Medicin_Model> dataForBooks) {

        medicin_models = new ArrayList<>();
        medicin_models.addAll(dataForBooks);
        notifyDataSetChanged();
    }
}