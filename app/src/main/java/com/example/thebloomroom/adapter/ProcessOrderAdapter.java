package com.example.thebloomroom.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebloomroom.R;
import com.example.thebloomroom.database.CustomerOrder;

import java.util.ArrayList;

// Adapter class for managing the RecyclerView that displays processed orders
public class ProcessOrderAdapter extends RecyclerView.Adapter<ProcessOrderAdapter.processOrderAdapter> {
    Context context;
    ArrayList<CustomerOrder> adds = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;

    // Constructor for the ProcessOrderAdapter
    public ProcessOrderAdapter(Context context, ArrayList<CustomerOrder> adds, SQLiteDatabase sqLiteDatabase, int processing_order_row) {
        this.context = context;
        this.adds = adds;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    // Creates a new ViewHolder when needed
    @NonNull
    @Override
    public ProcessOrderAdapter.processOrderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the processing_order_row layout for each item in the RecyclerView
        View view = inflater.inflate(R.layout.processing_order_row, null);
        return new ProcessOrderAdapter.processOrderAdapter(view);
    }

    // Binds data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull processOrderAdapter holder, int position) {
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
    public class processOrderAdapter extends RecyclerView.ViewHolder {
        TextView name,description,price,category,cname,address,qtn;
        Button btn;

        // Constructor for the ViewHolder
        public processOrderAdapter(@NonNull View itemView) {
            super(itemView);
            // Initialize views from the processing_order_row layout
            name = itemView.findViewById(R.id.process_order_name);
            description = itemView.findViewById(R.id.process_order_description);
            price = itemView.findViewById(R.id.process_order_price);
            category = itemView.findViewById(R.id.process_order_category);
            cname=itemView.findViewById(R.id.process_order_c_name);
            address=itemView.findViewById(R.id.process_order_address);
            qtn=itemView.findViewById(R.id.process_order_quantity);
            btn=itemView.findViewById(R.id.process_order_button);
        }
    }
}
