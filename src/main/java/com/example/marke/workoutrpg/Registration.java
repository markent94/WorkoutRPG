package com.example.marke.workoutrpg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {

    private EditText username, userpass, confirmpass;
    private String name, pass, con;
    private Button button;
    private Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = (EditText) findViewById(R.id.usernameEntry);
        userpass = (EditText) findViewById(R.id.passwordEntry);
        confirmpass = (EditText) findViewById(R.id.passwordCon);
        button = (Button) findViewById(R.id.create);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = username.getText().toString();
                pass = userpass.getText().toString();
                con = confirmpass.getText().toString();
                boolean userfree = true;

                DatabaseOperations dbo = new DatabaseOperations(ctx);
                Cursor cr = dbo.getInfo(dbo);
                cr.moveToFirst();

                do {
                    if(username.getText().toString().equals(cr.getString(0))) {
                        userfree = false;
                    }
                } while (cr.moveToNext());

                if (!userfree) {
                    Toast.makeText(getBaseContext(), "Account with that username is already active", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    userpass.setText("");
                    confirmpass.setText("");
                } else if(!pass.equals(con)) {
                    Toast.makeText(getBaseContext(), "Passwords are not matching", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    userpass.setText("");
                    confirmpass.setText("");
                } else if (pass.length() == 0) {
                    Toast.makeText(getBaseContext(), "Password not entered", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    userpass.setText("");
                    confirmpass.setText("");
                } else if (name.length() == 0) {
                    Toast.makeText(getBaseContext(), "Username not entered", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    userpass.setText("");
                    confirmpass.setText("");
                } else {
                    dbo.putInfo(dbo, name, pass);
                    Toast.makeText(getBaseContext(), "Account created", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
