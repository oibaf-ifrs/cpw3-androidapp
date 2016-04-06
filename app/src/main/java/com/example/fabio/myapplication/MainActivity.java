package com.example.fabio.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Aplicação beta.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (savedInstanceState != null) {
            /*
            ((EditText) findViewById(R.id.edit_message)).setText(savedInstanceState.getString("message"));
            ((TextView) findViewById(R.id.view_message)).setText(savedInstanceState.getString("view-message"));
            */
            ((EditText) findViewById(R.id.edit_message)).setText(savedInstanceState.getString("view-message"));
            ((TextView) findViewById(R.id.view_message)).setText(savedInstanceState.getString("message"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //must be public
    public void copyMessage(View view) {
        ((TextView) findViewById(R.id.view_message)).setText(((EditText) findViewById(R.id.edit_message)).getText());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("message", ((EditText) findViewById(R.id.edit_message)).getText().toString());
        savedInstanceState.putString("view-message", ((TextView) findViewById(R.id.view_message)).getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }


}
