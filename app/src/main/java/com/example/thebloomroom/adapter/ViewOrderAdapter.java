package com.example.thebloomroom.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebloomroom.R;
import com.example.thebloomroom.database.CustomerOrder;
import com.example.thebloomroom.database.Order;
import com.example.thebloomroom.view_follower_customer;

import java.util.ArrayList;

public class ViewOrderAdapter extends RecyclerView.Adapter<ViewOrderAdapter.viewOrderAdapter> {
    Context context;
    ArrayList<CustomerOrder> adds = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;

    public ViewOrderAdapter(Context context, ArrayList<CustomerOrder> adds, SQLiteDatabase sqLiteDatabase, int view_order_row) {
        this.context = context;
        this.adds = adds;
        this.sqLiteDatabase = sqLiteDatabase;
    }


    @NonNull
    @Override
    public ViewOrderAdapter.viewOrderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_order_row, null);
        return new ViewOrderAdapter.viewOrderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewOrderAdapter.viewOrderAdapter holder, int position) {
        final CustomerOrder add = adds.get(position);
        holder.name.setText(add.getName());
        holder.description.setText(add.getDescription());
        holder.price.setText(add.getPrice());
        holder.category.setText(add.getCategory());
        holder.cname.setText(add.getCustomer_Name());
        holder.address.setText(add.getAddress());
        holder.qtn.setText(add.getQuantity());
    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    public class viewOrderAdapter extends RecyclerView.ViewHolder {
        TextView name,description,price,category,cname,address,qtn;
        public viewOrderAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.order_name_view);
            description = itemView.findViewById(R.id.order_description_view);
            price = itemView.findViewById(R.id.order_price_view);
            category = itemView.findViewById(R.id.order_category_view);
            cname=itemView.findViewById(R.id.order_c_name_view);
            address=itemView.findViewById(R.id.order_address_view);
            qtn=itemView.findViewById(R.id.order_quantity_view);
        }
    }
}
