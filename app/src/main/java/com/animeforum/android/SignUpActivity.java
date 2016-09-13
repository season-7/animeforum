package com.animeforum.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Firebase.setAndroidContext(this);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            mEmailField = (EditText) findViewById(R.id.txt_email);
            mPasswordField = (EditText) findViewById(R.id.txt_password);

            Firebase ref = new Firebase("https://animeforum-54f62.firebaseio.com");
            ref.createUser("mEmailField", "mPasswordField", new Firebase.ValueResultHandler<Map<String, Object>>() {
                @Override
                public void onSuccess(Map<String, Object> result) {
                    System.out.println("Successfully created user account with uid: " + result.get("uid"));
                }

                @Override
                public void onError(FirebaseError firebaseError) {
                    // there was an error
                }
            });
        }

    }