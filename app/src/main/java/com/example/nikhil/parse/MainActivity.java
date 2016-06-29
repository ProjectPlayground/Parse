package com.example.nikhil.parse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            Intent fog=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(fog);

        } else {
            // show the signup or login screen
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

        switch (id){
            case R.id.action_Update:
                Intent i=new Intent(this,UpdateActivity.class);
                startActivity(i);
                break;

            case R.id.action_logout:
                ParseUser.logOut();
                //back to login page
                Intent log=new Intent(this,LoginActivity.class);
                startActivity(log);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    }