package com.example.restaurantapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class SupplierDialog extends Dialog implements
        android.view.View.OnClickListener {

    public Button add, cancel;
    EditText name,phone;
    TextView heading;
    Context context;
    int position=0;

    public SupplierDialog(@NonNull Context context, int currentTab) {
        super(context);
        this.context=context;
        position=currentTab;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.supplier_add_dialog);
        add = (Button) findViewById(R.id.supplier_add_button);
        cancel = (Button) findViewById(R.id.supplier_cencel_button);
        name=findViewById(R.id.supplier_name);
        phone=findViewById(R.id.supplier_phone);
        heading=findViewById(R.id.add_supplier_heading);
        add.setOnClickListener(this);
        cancel.setOnClickListener(this);
        if(position==0)
        {
            name.setHint("Enter Supplier Name");
            phone.setHint("Enter Supplier Phone Number");
            heading.setText("ADD SUPPLIER");
        }
        else if(position==1)
        {
            name.setHint("Enter Menu Item Name");
            phone.setHint("Enter Price");
            heading.setText("ADD MENU ITEM");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.supplier_add_button:
                DataBaseHandler db=new DataBaseHandler(context);
                if(position==0)
                db.AddSupplier(new Supplier(name.getText().toString(),phone.getText().toString()));
                else if(position==1)
                    db.AddMenuItem(new MenuItem(name.getText().toString(),Double.parseDouble(phone.getText().toString())));
                this.dismiss();
                break;
            case R.id.supplier_cencel_button:
                this.dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
