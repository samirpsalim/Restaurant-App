package com.example.restaurantapp;

import static android.content.Context.MODE_PRIVATE;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {

    EditText username,fullname,email,password1,password2;
    Button register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username=view.findViewById(R.id.newusername_input);
        fullname=view.findViewById(R.id.newname_input);
        email=view.findViewById(R.id.newemail_input);
        password1=view.findViewById(R.id.password1_input);
        password2=view.findViewById(R.id.password2_input);
        register=view.findViewById(R.id.register_button);
        register.setOnClickListener(this::registerUser);
    }

    private void registerUser(View view) {
        String fname= fullname.getText().toString();
        String usename= username.getText().toString();
        String mail=email.getText().toString();
        String pswrd1= password1.getText().toString();
        String pswrd2=password2.getText().toString();
        if(fname.isEmpty() || usename.isEmpty() || mail.isEmpty() || pswrd1.isEmpty() || pswrd2.isEmpty())
            Toast.makeText(getContext(), "Missing fields", Toast.LENGTH_SHORT).show();
        else if (!pswrd1.equals(pswrd2))
            Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
        else {
            ContentValues values = new ContentValues();
            values.put("NAME",fname);
            values.put("USERNAME",usename);
            values.put("EMAIL",mail);
            values.put("PASSWORD",pswrd1);
            DataBaseHandler db= new DataBaseHandler(getContext());
            db.addUser(values);
            Utils.saveToPreference(getActivity(),usename, pswrd1 ,1);
            ((MainActivity)getActivity()).goToNext();
        }
    }
}