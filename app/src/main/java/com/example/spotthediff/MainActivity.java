package com.example.spotthediff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btLogin;
    private EditText etUsername;
    private EditText etPassword;
    private SharedPreferences sharedPreferences;
    private Usermodel myUser;
    java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getUserCredentials();

    }

    private void initViews() {
        btLogin= findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);
        etUsername= findViewById(R.id.etUsername);
        etPassword= findViewById(R.id.etPassword);
    }



    @Override
    public void onClick(View v) {
        
        // Login button clicked
        if (btLogin == v) {
            initUserObject();
            storeUserCredentials();

            Intent intent = new Intent(MainActivity.this, YourProfileActivity.class);
            startActivity(intent);
        }
    }


    private void getUserCredentials() {  // sp has been initialized
        // working with shared preferences while opening a layout
        sharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE); //open file
        etUsername.setText(sharedPreferences.getString(getString(R.string.user_name), ""));
        etPassword.setText(sharedPreferences.getString(getString(R.string.user_password), ""));

        //
        // if the user has the same name as in SP then click on Continue
        String name1 = etUsername.getText().toString();
        Toast.makeText(this, "If you are  " + name1 + " then press Continue , otherwise put your name", Toast.LENGTH_LONG).show();

    }

    private void storeUserCredentials()
    {
        logger.info("Yan");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.user_name),myUser.getName());  // "user_details" "Michelle"
        editor.putString(getString(R.string.user_password), myUser.getPassword()); //"user_password" "123456"

        // write the data
        editor.apply(); // also possible commit...

    }

    private void initUserObject() {

        // read data from edit text
        String name = String.valueOf(etUsername.getText());
        if (name.isEmpty())
            name = "Guest";
        String password = etPassword.getText().toString();
        if (password.isEmpty())
            myUser = new Usermodel(name);
        else
            myUser = new Usermodel(name, password); //

        }

    }


