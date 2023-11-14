package com.example.thebloomroom.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebloomroom.R;
import com.example.thebloomroom.database.Followers;;
import com.example.thebloomroom.database.Order;
import com.example.thebloomroom.order_follower_by_customer;
import com.example.thebloomroom.view_follower_customer;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.orderAdapter> {
    Context context;
    ArrayList<Followers> adds = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;

    public OrderAdapter(Context context, ArrayList<Followers> adds, SQLiteDatabase sqLiteDatabase, int singleData) {
        this.context = context;
        this.adds = adds;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public OrderAdapter.orderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_follower_cutomer_row, null);
        return new OrderAdapter.orderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.orderAdapter holder, int position) {
        final Followers add = adds.get(position);
        holder.name.setText(add.getName());
        holder.description.setText(add.getDescription());
        holder.price.setText(add.getPrice());
        holder.category.setText(add.getCategory());

        holder.order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("id",add.getId());
                bundle.putString("Name", add.getName());
                bundle.putString("Description", add.getDescription());
                bundle.putString("Price", add.getPrice());
                bundle.putString("Category", add.getCategory());
                Intent intent = new Intent(context, order_follower_by_customer.class);
                intent.putExtra("userdata", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    public class orderAdapter extends RecyclerView.ViewHolder {
        TextView name,description,price,category;
        Button order;
        public orderAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            category = itemView.findViewById(R.id.category);
            order=itemView.findViewById(R.id.order);
        }
    }
}
