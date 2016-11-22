package com.example.marke.workoutrpg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {
    private Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        DatabaseOperations dbo = new DatabaseOperations(ctx);

        Cursor cr = dbo.getInfoUser(dbo, message);
        cr.moveToFirst();

       // BACK, TableInfo.BICEPS,
               // TableInfo.CALVES, TableInfo.CHEST, TableInfo.CORE, TableInfo.QUADRICEPS, TableInfo.SHOULDERS, TableInfo.TRICEPS


        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView back = (TextView)findViewById(R.id.back);
        back.setText("Back " + (int) cr.getDouble(2));

        TextView biceps = (TextView)findViewById(R.id.biceps);
        biceps.setText("Biceps " + (int) cr.getDouble(3));

        TextView calves = (TextView)findViewById(R.id.calves);
        calves.setText("Calves " + (int) cr.getDouble(4));

        TextView chest = (TextView)findViewById(R.id.chest);
        chest.setText("Chest " + (int) cr.getDouble(5));

        TextView core = (TextView)findViewById(R.id.core);
        core.setText("Core " + (int) cr.getDouble(6));

        TextView quads = (TextView)findViewById(R.id.quads);
        quads.setText("Quadriceps " + (int) cr.getDouble(7));

        TextView shoulders = (TextView)findViewById(R.id.shoulders);
        shoulders.setText("Shoulders " + (int) cr.getDouble(8));

        TextView triceps = (TextView)findViewById(R.id.triceps);
        triceps.setText("Triceps " + (int) cr.getDouble(9));

    }
}
