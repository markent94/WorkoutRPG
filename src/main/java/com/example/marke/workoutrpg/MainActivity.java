package com.example.marke.workoutrpg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.marke.workoutrpg";
    private Context ctx = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

    }

    public void nextView(View view) {
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        DatabaseOperations dbo = new DatabaseOperations(ctx);

        Cursor cr = dbo.getInfo(dbo);
        cr.moveToFirst();

        do {
            if(username.getText().toString().equals(cr.getString(0)) && password.getText().toString().equals(cr.getString(1)) && cr.getString(0).length() != 0) {
                Toast.makeText(getBaseContext(), "Login successful, hello " + cr.getString(0), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, DisplayMessageActivity.class);
                EditText account = (EditText)findViewById(R.id.username);
                String message = account.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        } while (cr.moveToNext());
        Toast.makeText(getBaseContext(), "Incorrect username or password" + cr.getString(0), Toast.LENGTH_SHORT).show();
    }

    public void rView(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
}
