package com.example.thebloomroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thebloomroom.database.CustomerOrder;
import com.example.thebloomroom.database.DBConnector;
import com.example.thebloomroom.database.DataHandler;

public class order_follower_by_customer extends AppCompatActivity {
    TextView name, description, price, category;
    EditText c_name, address, quantity;
    int id = 0;
    DataHandler datahandler = new DataHandler(this);
    DBConnector db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_follower_by_customer);

        name=findViewById(R.id.follower_name_view);
        description=findViewById(R.id.follower_description_view);
        price=findViewById(R.id.follower_price_view);
        category=findViewById(R.id.follower_category_view);
        c_name=findViewById(R.id.customer_name_input);
        address=findViewById(R.id.customer_address_input);
        quantity=findViewById(R.id.follower_quantity_input);
        datahandler.openDB();

        db = new DBConnector(this);
        getData();
    }

    // Retrieve data from the intent
    private void getData() {
        if (getIntent().getBundleExtra("userdata") != null) {
            Bundle bundle = getIntent().getBundleExtra("userdata");
            id=bundle.getInt("id");
            name.setText(bundle.getString("Name"));
            description.setText(bundle.getString("Description"));
            price.setText(bundle.getString("Price"));
            category.setText(bundle.getString("Category"));
        }
    }

    //name validation
    private boolean validName() {
        String Name = c_name.getText().toString().trim();
        if (Name.isEmpty()) {
            c_name.setError("Name is Required.");
            return false;
        } else {
            name.setError(null);
            return true;
        }
    }

    //Address validation
    private boolean validAddress() {
        String Address = address.getText().toString().trim();
        if (Address.isEmpty()) {
            address.setError("Address is Required.");
            return false;
        } else {
            address.setError(null);
            return true;
        }
    }

    //Quantity validation
    private boolean validQuantity() {
        String Quantity = quantity.getText().toString().trim();
        if (Quantity.isEmpty()) {
            quantity.setError("Quantity is Required.");
            return false;
        } else {
            quantity.setError(null);
            return true;
        }
    }


    // Add order when the "Add Order" button is clicked
    public void AddOrder(View v) {
        String Name = name.getText().toString().trim();
        String Description = description.getText().toString().trim();
        String Price = price.getText().toString().trim();
        String Category = category.getText().toString().trim();
        String C_Name = c_name.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String Quantity = quantity.getText().toString().trim();

        // Validate input fields
        if (!validName() | !validAddress() | !validQuantity()) {
            return;
        }

        // Create a CustomerOrder object and add it to the database
        CustomerOrder customerOrder = new CustomerOrder(Name,Description,Price,Category,C_Name,Address,Quantity);
        try {
            datahandler.addOrder(customerOrder);
            Toast.makeText(getApplicationContext(), "Toy Ordered Successfully.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(order_follower_by_customer.this, Customer_dashboard.class);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Toy Ordered Failed.", Toast.LENGTH_LONG).show();
        }

    }
}