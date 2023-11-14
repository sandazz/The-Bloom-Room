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
import com.example.thebloomroom.add_category;
import com.example.thebloomroom.database.Category;
import com.example.thebloomroom.database.DBConnector;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryAdapter> {
    Context context;
    ArrayList<Category> adds = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    int singleData;

    public CategoryAdapter(Context context, ArrayList<Category> adds, SQLiteDatabase sqLiteDatabase, int singleData){
        this.context = context;
        this.adds = adds;
        this.sqLiteDatabase = sqLiteDatabase;
        this.singleData = singleData;
    }

    @NonNull
    @Override
    public CategoryAdapter.categoryAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_row,null);
        return new categoryAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdapter holder, @SuppressLint("RecyclerView") int position) {
        final Category add = adds.get(position);
        holder.admin_category_view_row.setText(add.getName());

        holder.admin_category_view_row_edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("id",add.getId());
                bundle.putString("Name", add.getName());
                Intent intent = new Intent(context, add_category.class);
                intent.putExtra("userdata", bundle);
                context.startActivity(intent);
            }
        });

        holder.admin_category_view_row_delete_button.setOnClickListener(new View.OnClickListener() {
            DBConnector db = new DBConnector(context);
            @Override
            public void onClick(View view) {
                sqLiteDatabase =db.getReadableDatabase();
                long delete=sqLiteDatabase.delete("Category","id="+add.getId(),null);
                if (delete != -1) {
                    Toast.makeText(context,"Deleted Successfully",Toast.LENGTH_SHORT).show();
                    adds.remove(position);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    public class categoryAdapter extends RecyclerView.ViewHolder {
        TextView admin_category_view_row;
        Button admin_category_view_row_edit_button, admin_category_view_row_delete_button;
        public categoryAdapter(@NonNull View itemView) {
            super(itemView);
            admin_category_view_row = itemView.findViewById(R.id.admin_category_view_row);

            admin_category_view_row_edit_button = itemView.findViewById(R.id.admin_category_view_row_edit_button);
            admin_category_view_row_delete_button = itemView.findViewById(R.id.admin_category_view_row_delete_button);
        }
    }
}
