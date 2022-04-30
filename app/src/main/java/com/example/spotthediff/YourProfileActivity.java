package com.example.spotthediff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class YourProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btPlay;
    private TextView tvUsername;
    private TextView tvLevel;
    private TextView tvBestScore;
    private TextView tvLastScore;
    private FirebaseDatabase database;
    private DatabaseReference userRef;
    private static final String USERS = "users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yourprofile);
        initViews();
    }



    @Override
    public void onClick(View v) {
        if (btPlay == v) {
            Intent intent = new Intent(YourProfileActivity.this, level11Activity.class);
            startActivity(intent); }

    }

    private void initViews() {
        btPlay = findViewById(R.id.btPlay);
        btPlay.setOnClickListener(this);
        tvUsername = findViewById(R.id.tvUsername);
        tvUsername.setOnClickListener(this);
        tvLevel = findViewById(R.id.tvLevel);
        tvLevel.setOnClickListener(this);
        tvBestScore = findViewById(R.id.tvBestScore);
        tvBestScore.setOnClickListener(this);
        tvLastScore = findViewById(R.id.tvLastScore);
        tvLastScore.setOnClickListener(this);
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference(USERS);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.yourprofile) {
            Intent intent = new Intent(this, YourProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.instructions) {
            Intent intent = new Intent(this, instructions.class);
            startActivity(intent);
        }
        if (id == R.id.share){
            Intent intent = new Intent(this, ShareActivity.class);
            startActivity(intent);
        }
        return true;
    }
}