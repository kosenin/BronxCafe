package com.kosenin.boston.bronxcafe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.local.UserTokenStorageFactory;
import com.kosenin.boston.bronxcafe.Model.BackendlessData;
import com.kosenin.boston.bronxcafe.R;

import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;

public class login_activity extends AppCompatActivity {

    private EditText phone;
    private EditText password;
    private EditText name;
    private Button registerButton;
    private Button loginButton;
    private String userToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BackendlessData.BackendlessInit(getApplicationContext());

        phone = findViewById(R.id.phone_input);
        name = findViewById(R.id.name_input);
        password = findViewById(R.id.password_input);
        registerButton = findViewById(R.id.register_button);
        loginButton = findViewById(R.id.login_button);
        userToken = UserTokenStorageFactory.instance().getStorage().get();


        if (userToken != null && !userToken.equals("")) {
            Intent intent = new Intent(login_activity.this, MainActivity.class);
            this.startActivity(intent);
        }


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BackendlessUser user = new BackendlessUser();

                user.setProperty("phone", phone.getText().toString());
                user.setPassword(password.getText().toString());
                user.setProperty("name", name.getText().toString());

                Log.e("Register", phone.getText().toString());
                Log.e("Register", password.getText().toString());
                Log.e("Register", name.getText().toString());

                Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {

                        Toast toast = Toast.makeText(login_activity.this, "Вы зарегистрированы, теперь войдите", Toast.LENGTH_LONG);
                        toast.show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });

            }


        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backendless.UserService.login(phone.getText().toString(), password.getText().toString(), new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Intent intent = new Intent(login_activity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);


                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                }, true);
            }
        });


    }


}