package com.example.satan.nfcattendance;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewRoutine extends AppCompatActivity {

    ImageView routineImage;
    Button btn_adit, btn_dit, btn_f1, refreshAttendanceButton;
    DatabaseReference attendanceRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_routine);

        // Initialize Firebase Database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        attendanceRef = database.getReference("attendance");

        // Initialize UI components
        routineImage = findViewById(R.id.routineImage);
        btn_adit = findViewById(R.id.btn_adit);
        btn_dit = findViewById(R.id.btn_dit);
        btn_f1 = findViewById(R.id.btn_f1);
        refreshAttendanceButton = findViewById(R.id.refreshAttendanceButton);

        // Set click listeners for buttons
        btn_adit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adit();
            }
        });

        btn_dit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dit();
            }
        });

        btn_f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f1();
            }
        });

        // Set click listener for the Refresh Attendance button
        refreshAttendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshAttendance();
            }
        });
    }

    // Load image for ADIT
    public void adit() {
        String Uri1 = "https://firebasestorage.googleapis.com/v0/b/graduation-project-6e1a9.appspot.com/o/IMG_3167.jpg?alt=media&token=a9cdd515-c7f4-418b-abe2-144df24683e8";
        Glide.with(getApplicationContext()).load(Uri1).into(routineImage);
    }

    // Load image for DIT
    public void dit() {
        String Uri1 = "https://firebasestorage.googleapis.com/v0/b/graduation-project-6e1a9.appspot.com/o/IMG_3168.jpg?alt=media&token=2ae066f0-3808-4258-9e2b-576da5588967";
        Glide.with(getApplicationContext()).load(Uri1).into(routineImage);
    }

    // Load image for F1
    public void f1() {
        String Uri1 = "https://firebasestorage.googleapis.com/v0/b/graduation-project-6e1a9.appspot.com/o/IMG_3169.jpg?alt=media&token=fee0f78f-9d3d-4392-987c-a90bfb5d9084";
        Glide.with(getApplicationContext()).load(Uri1).into(routineImage);
    }

    // Write attendance data to Firebase database
    public void refreshAttendance() {
        attendanceRef.setValue("Meshari attended");
        Toast.makeText(this, "Attendance refreshed and sent to the database", Toast.LENGTH_SHORT).show();
    }
}
