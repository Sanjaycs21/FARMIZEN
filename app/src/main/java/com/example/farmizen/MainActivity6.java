package com.example.farmizen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity6 extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    private MaterialButton btn;
    private ImageView arrow;
    String[] courses = {"Bank", "SBI",
            "INDIAN BANK", "HDFC BANK",
            "KVB", "CANARA BANK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        btn=findViewById(R.id.button);
        arrow=findViewById(R.id.arrow);
        Spinner spin = findViewById(R.id.coursesspinner);
        spin.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);
        View gif=getLayoutInflater().inflate(R.layout.gifview,null);

        arrow.setOnClickListener(v -> {
            finish();
        });

        btn.setOnClickListener(view -> {
            AlertDialog alert=new AlertDialog.Builder(this)
                    .setTitle("PAYMENT DETAILS")
                    .setView(gif)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create();
            alert.show();
        });

    }

    // Performing action when ItemSelected
    // from spinner, Overriding onItemSelected method
    @Override
    public void onItemSelected(AdapterView<? >arg0,
                               View arg1,
                               int position,
                               long id) {

        // make toastof name of course
        // which is selected in spinner
        Toast.makeText(getApplicationContext(),
                        courses[position],
                        Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // Auto-generated method stub
    }
    @Override
    public void onBackPressed() {
        AlertDialog alert=new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Do you want to exit?")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).create();
        alert.show();
    }

}

