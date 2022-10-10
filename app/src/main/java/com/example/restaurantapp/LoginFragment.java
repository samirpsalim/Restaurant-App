package com.example.restaurantapp;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class LoginFragment extends Fragment {

    EditText username, password;
    Button login;
    TextView register,forgot;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username=view.findViewById(R.id.username_input);
        password=view.findViewById(R.id.password_input);
        login=view.findViewById(R.id.login_button);
        register=view.findViewById(R.id.register_link);
        forgot=view.findViewById(R.id.forgot_password);
        login.setOnClickListener(this::tryLogin);
        register.setOnClickListener(this::proceedToRegister);
        forgot.setOnClickListener(this::passwordChange);
    }

    private void passwordChange(View view) {
        NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.changePassword);
    }

    private void proceedToRegister(View view) {
        NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.ProceedtoRegister);
    }

    private void tryLogin(View view) {
        if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
            Toast.makeText(getContext(),"Please fill in username and password",Toast.LENGTH_SHORT).show();
        else{
            DataBaseHandler db= new DataBaseHandler(getContext());
            String user=db.userExists(username.getText().toString(),password.getText().toString());
            if(user!=null){
                Utils.saveToPreference(getActivity(),username.getText().toString(), password.getText().toString() ,1);
                ((MainActivity)getActivity()).goToNext();
            }
            else
                Toast.makeText(getContext(),"Invalid username and password. Please try again",Toast.LENGTH_LONG).show();
        }
    }
}