package com.kosenin.boston.bronxcafe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.kosenin.boston.bronxcafe.Model.BackendlessData;
import com.kosenin.boston.bronxcafe.R;

public class login_activity extends AppCompatActivity {

    private EditText phone;
    private EditText password;
    private EditText name;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BackendlessData.BackendlessInit(getApplicationContext());

        phone = findViewById(R.id.phone_input);
        name = findViewById(R.id.name_input);
        password = findViewById(R.id.password_input);
        registerButton = findViewById(R.id.register_button);

        final BackendlessUser user = new BackendlessUser();


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setProperty("phone", phone.getText().toString());
                user.setPassword(password.getText().toString());
                user.setProperty("name", name.getText().toString());

                Log.e("Register", phone.getText().toString());
                Log.e("Register", password.getText().toString());
                Log.e("Register", name.getText().toString());

                Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Intent intent = new Intent(login_activity.this, MainActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });

            }
        });


    }
}
