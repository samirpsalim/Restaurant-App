package com.example.restaurantapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PasswordFragment extends Fragment {

    EditText password1,password2,email;
    Button reset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email=view.findViewById(R.id.password_reset_email_input);
        password1=view.findViewById(R.id.password_new_input);
        password2=view.findViewById(R.id.confirm_password_input);
        reset=view.findViewById(R.id.password_button);
        reset.setOnClickListener(this::reset);
    }

    private void reset(View view) {
        if(!password1.getText().toString().equals(password2.getText().toString()))
            Toast.makeText(getContext(), "Passwords do not match. Try again", Toast.LENGTH_SHORT).show();
        else{
            DataBaseHandler db=new DataBaseHandler(getContext());
            if(db.userExists(email.getText().toString())==null)
                Toast.makeText(getContext(), "Unrecognized email. Please try again", Toast.LENGTH_SHORT).show();
            else {
                db.updateUser(email,password1);
                NavHostFragment.findNavController(PasswordFragment.this).navigate(R.id.returnToLogin);
            }

        }
    }
}