package com.example.nikhil.parse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final EditText mUsername;
        final EditText mEmail;
        final EditText mPassword;
        Button mSignUp;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Parse.initialize(this, "aHCb6PyxNylllla6v5KIlMIBilYc4Tr7cAyP9CK8", "ZzjPAiuWGsItsuPKhuXahoylMU6hUdHdwzGEqq9B");

        //initialize
        mUsername=(EditText) findViewById(R.id.usernameid);
        mEmail=(EditText) findViewById(R.id.emaiid);
        mPassword=(EditText) findViewById(R.id.passwordid);
        mSignUp=(Button) findViewById(R.id.register);


        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username=mUsername.getText().toString().trim();
                String MailId=mEmail.getText().toString().trim();
                String Password=mPassword.getText().toString().trim();

                //Parse
                ParseUser user = new ParseUser();
                user.setUsername(Username);
                user.setPassword(Password);
                user.setEmail(MailId);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        //sign up successful
                        if (e==null) {
                            Toast.makeText(RegisterActivity.this, "Welcome To Parse", Toast.LENGTH_LONG).show();
                            //Take user to homepage
                            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(i);
                        }
                        else {
                            //something went wrong
                        }
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
    }
