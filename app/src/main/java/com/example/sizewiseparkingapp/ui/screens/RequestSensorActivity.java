package com.example.sizewiseparkingapp.ui.screens;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sizewiseparkingapp.R;
import com.example.sizewiseparkingapp.ui.base.BaseDrawerActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.android.material.materialswitch.MaterialSwitch;

public class RequestSensorActivity extends BaseDrawerActivity {
    private MaterialButton uploadImageButton, submitRequestButton;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_request_sensor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        setupListeners();
    }

    private void initializeViews() {
        TextInputEditText addressInput = findViewById(R.id.addressInput);
        TextInputEditText floorInput = findViewById(R.id.floorInput);
        MaterialSwitch facingStreetSwitch = findViewById(R.id.facingStreetSwitch);
        uploadImageButton = findViewById(R.id.uploadImageButton);
        submitRequestButton = findViewById(R.id.submitRequestButton);
        MaterialTextView requestSensorTitle = findViewById(R.id.requestSensorTitle);
    }

    private void setupListeners() {
        uploadImageButton.setOnClickListener(v -> 
            Toast.makeText(this, "Image upload feature not implemented yet", Toast.LENGTH_SHORT).show());

        submitRequestButton.setOnClickListener(v -> showThankYouDialog());
    }

    private void showThankYouDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.thank_you_title));
        builder.setMessage(getString(R.string.thank_you_message));
        builder.setPositiveButton(getString(R.string.ok), (dialog, which) -> {
            dialog.dismiss();
            finish(); // Simulate navigating back to the home screen
        });
        builder.show();
    }
}
