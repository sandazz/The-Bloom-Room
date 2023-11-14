package com.example.thebloomroom.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebloomroom.R;
import com.example.thebloomroom.add_followers;
import com.example.thebloomroom.database.DBConnector;
import com.example.thebloomroom.database.Followers;

import java.util.ArrayList;

// Adapter class for managing the RecyclerView that displays followers
public class FollowerAdapter extends RecyclerView.Adapter<FollowerAdapter.followerAdapter> {
    Context context;
    ArrayList<Followers> adds = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    int singleData;

    // Constructor for the FollowerAdapter
    public FollowerAdapter(Context context, ArrayList<Followers> adds, SQLiteDatabase sqLiteDatabase, int singleData) {
        this.context = context;
        this.adds = adds;
        this.sqLiteDatabase = sqLiteDatabase;
        this.singleData = singleData;
    }

    // Creates a new ViewHolder when needed
    @NonNull
    @Override
    public FollowerAdapter.followerAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the follower_row layout for each item in the RecyclerView
        View view = inflater.inflate(R.layout.follower_row, null);
        return new FollowerAdapter.followerAdapter(view);
    }

    // Binds data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull FollowerAdapter.followerAdapter holder, int position) {
        final Followers add = adds.get(position);
        // Set follower details to the TextViews in the ViewHolder
        holder.follower_name.setText(add.getName());
        holder.follower_description.setText(add.getDescription());
        holder.follower_price.setText(add.getPrice());
        holder.follower_category.setText(add.getCategory());

        // Set up an OnClickListener for the "Edit" button in each row
        holder.follower_edit.setOnClickListener(new View.OnClickListener() {
            // Create a Bundle to pass data to the 'add_followers' activity
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("id",add.getId());
                bundle.putString("Name", add.getName());
                bundle.putString("Description", add.getDescription());
                bundle.putString("Price", add.getPrice());
                bundle.putString("Category", add.getCategory());
                // Create an Intent to start the 'add_followers' activity
                Intent intent = new Intent(context, add_followers.class);
                intent.putExtra("userdata", bundle);
                context.startActivity(intent);
            }
        });

        // Set up an OnClickListener for the "Delete" button in each row
        holder.follower_delete.setOnClickListener(new View.OnClickListener() {
            DBConnector db = new DBConnector(context);
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                // Get a readable database from the DBConnector
                sqLiteDatabase =db.getReadableDatabase();
                // Delete the follower from the database
                long delete=sqLiteDatabase.delete("Followers","id="+add.getId(),null);
                if (delete != -1) {
                    // If deletion is successful, show a toast message and update the RecyclerView
                    Toast.makeText(context,"Deleted Successfully",Toast.LENGTH_SHORT).show();
                    adds.remove(position);
                    notifyDataSetChanged();
                }
            }
        });
    }

    // Returns the total number of items in the data set
    @Override
    public int getItemCount() {
        return adds.size();
    }

    // ViewHolder class for holding the views for each item in the RecyclerView
    public class followerAdapter extends RecyclerView.ViewHolder {
        TextView follower_name,follower_description,follower_price,follower_category;
        Button follower_edit, follower_delete;

        // Constructor for the ViewHolder
        public followerAdapter(@NonNull View itemView) {
            super(itemView);
            // Initialize views from the follower_row layout
            follower_name = itemView.findViewById(R.id.follower_row_name);
            follower_description = itemView.findViewById(R.id.follower_row_description);
            follower_price = itemView.findViewById(R.id.follower_row_price);
            follower_category = itemView.findViewById(R.id.follower_row_category);

            follower_edit = itemView.findViewById(R.id.follower_row_edit);
            follower_delete = itemView.findViewById(R.id.follower_row_delete);
        }
    }
}
