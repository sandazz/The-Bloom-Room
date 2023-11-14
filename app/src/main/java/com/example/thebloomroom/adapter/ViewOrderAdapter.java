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

import java.util.ArrayList;

// Adapter class for managing the RecyclerView that displays customer orders
public class ViewOrderAdapter extends RecyclerView.Adapter<ViewOrderAdapter.viewOrderAdapter> {
    Context context;
    ArrayList<CustomerOrder> adds = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;

    // Constructor for the ViewOrderAdapter
    public ViewOrderAdapter(Context context, ArrayList<CustomerOrder> adds, SQLiteDatabase sqLiteDatabase, int view_order_row) {
        this.context = context;
        this.adds = adds;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    // Creates a new ViewHolder when needed
    @NonNull
    @Override
    public ViewOrderAdapter.viewOrderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the view_order_row layout for each item in the RecyclerView
        View view = inflater.inflate(R.layout.view_order_row, null);
        return new ViewOrderAdapter.viewOrderAdapter(view);
    }

    // Binds data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewOrderAdapter.viewOrderAdapter holder, int position) {
        final CustomerOrder add = adds.get(position);
        // Set order details to the TextViews in the ViewHolder
        holder.name.setText(add.getName());
        holder.description.setText(add.getDescription());
        holder.price.setText(add.getPrice());
        holder.category.setText(add.getCategory());
        holder.cname.setText(add.getCustomer_Name());
        holder.address.setText(add.getAddress());
        holder.qtn.setText(add.getQuantity());
    }

    // Returns the total number of items in the data set
    @Override
    public int getItemCount() {
        return adds.size();
    }

    // ViewHolder class for holding the views for each item in the RecyclerView
    public class viewOrderAdapter extends RecyclerView.ViewHolder {
        TextView name,description,price,category,cname,address,qtn;

        // Constructor for the ViewHolder
        public viewOrderAdapter(@NonNull View itemView) {
            super(itemView);
            // Initialize views from the view_order_row layout
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
