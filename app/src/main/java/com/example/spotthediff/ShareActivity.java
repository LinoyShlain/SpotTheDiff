package com.example.spotthediff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private TextView tvThankYou;
    private TextView tvRateTheApp;
    private Spinner phoneSpinner;
    private EditText etPhone;
    private Switch smMusic;
    private Button btShare;
    private Button btConfirm;
    private EditText etMail;
    String email_valid="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initViews();
        loadSpinner();
    }

    private void initViews() {
        etMail = findViewById(R.id.etMail);
        etMail.setOnClickListener(this);
        etPhone = findViewById(R.id.etPhone);
        etPhone.setOnClickListener(this);
        btShare = findViewById(R.id.btShare);
        btShare.setOnClickListener(this);
        btConfirm = findViewById(R.id. btConfirm);
        btConfirm.setOnClickListener(this);
        phoneSpinner=findViewById(R.id.spin_phone);
        if(phoneSpinner!=null){
            phoneSpinner.setOnItemSelectedListener(this);}
    }

    private void loadSpinner() {
        ArrayAdapter<CharSequence> adapterPhone = ArrayAdapter.createFromResource(this, R.array.num_array, android.R.layout.simple_spinner_item);
        adapterPhone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (phoneSpinner != null) {
            phoneSpinner.setAdapter(adapterPhone);
        }
    }

    private void send() {
        final String email= etMail.getText().toString();
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to= {email};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "App recommendation");
        intent.putExtra(Intent.EXTRA_TEXT," Hey! I wanted to share with you an educational and fun app that can help you improve your English! Its called LearningEnglish!");
        intent.setType("message/rfc822");
        Intent.createChooser(intent, "Send Email");
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
    if(v==btShare)
    send();
    if(v==btConfirm)
        Toast.makeText(this, "Thank you", Toast.LENGTH_SHORT).show();
        if(v==btShare){
            if(etMail.getText().toString().trim().matches(email_valid)){
                send();

            }
            else
                etMail.setError("Your mail is incorrect, check it again please");

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected= parent.getItemAtPosition(position).toString();
        switch (selected){

            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}