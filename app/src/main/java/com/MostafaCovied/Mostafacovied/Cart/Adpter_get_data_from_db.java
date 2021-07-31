package com.MostafaCovied.Mostafacovied.Cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.Models.Medicin_Model;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adpter_get_data_from_db extends RecyclerView.Adapter<Adpter_get_data_from_db.defin_view_of_car_shope> {
    public Adpter_get_data_from_db(ArrayList<Medicin_Model> models) {
        this.models = models;
    }

    ArrayList<Medicin_Model> models;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("pharmacy_sales");
    OnclickListner listner;
    String med_id;
    String UID;
//    public Adpter_get_data_from_db(ArrayList<Medicin_Model> models, OnclickListner listner) {
//        this.models = models;
//        this.listner = listner;
//    }
    @NonNull
    @Override
    public defin_view_of_car_shope onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_cart_show, parent, false);
        return new defin_view_of_car_shope(view);
    }
    @Override
    public void onBindViewHolder(@NonNull defin_view_of_car_shope holder, final int position) {
        holder.textView_name.setText(models.get(position).getMed_name());
        holder.textView_desc.setText(models.get(position).getMed_descraption());
        holder.textView_count.setText(models.get(position).getCount());
//        holder.textView_pp_price.setText(models.get(position).getMed_price());
        Picasso.get().load(models.get(position).getMed_image()).into(holder.imageView);
//        holder.textView_pp_price.setText(models.get(position).getMult());
        holder.textView_pp_price.setText(models.get(position).getMult());
            holder.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    firebaseFirestore.collection("pharmacy_sales").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                String uid = String.valueOf(task.getResult().getDocuments().get(position).get("order_id"));
                                Toast.makeText(v.getContext(), uid, Toast.LENGTH_SHORT).show();
                                firebaseFirestore.collection("pharmacy_sales").document(uid).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(v.getContext(), "deleted", Toast.LENGTH_SHORT).show();
                                            synchronized (firebaseFirestore) {
                                               // models.remove(position);
                                                //models.clear();
                                                firebaseFirestore.notifyAll();
                                                firebaseFirestore.notify();
                                                notifyDataSetChanged();


                                            } } }
                                }); } }
                    });
                       //firebaseFirestore.collection("pharmacy_sales").document(models.get(position).getOrder_id()).set(null);
                }
            });
    }
    @Override
    public int getItemCount() {
        return models.size();
    }
    class defin_view_of_car_shope extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView_pp_price;
        TextView textView_name, textView_desc, textView_count;
        ImageButton imageButton;

        public defin_view_of_car_shope(@NonNull View itemView) {

            super(itemView);
            imageButton = itemView.findViewById(R.id.delete_);
            imageView = itemView.findViewById(R.id.image_custome_order);
            textView_name = itemView.findViewById(R.id.name_custome_order);
            textView_desc = itemView.findViewById(R.id.descraption_order);
            textView_count = itemView.findViewById(R.id.count_of_order);
            textView_pp_price = itemView.findViewById(R.id.pp_price);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listner.onItemClick(getAdapterPosition());
//
//                }
//            });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onItemClick(getAdapterPosition());
            }
        });
        }
    }
}
//    FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
//    String id=firebaseUser.getUid();
//                databaseReference.child(id).child(models.get(position).getMed_name()).setValue(null);
//synchronized(databaseReference){
//
//        databaseReference.notifyAll();
//        databaseReference.notify();
//        notifyDataSetChanged();
//        }