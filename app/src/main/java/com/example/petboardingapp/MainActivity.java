package com.example.petboardingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDays, etDate;
    Spinner spnPetType;
    CheckBox cbVac;
    Button btnSend;

    private FirebaseFirestore db;
    private CollectionReference colRef;
    private DocumentReference docRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etDays = findViewById(R.id.etDays);
        etDate = findViewById(R.id.etDate);
        spnPetType = findViewById(R.id.spnPetType);
        cbVac = findViewById(R.id.cbVac);
        btnSend = findViewById(R.id.btnSend);

        db = FirebaseFirestore.getInstance();

        colRef = db.collection("firebasehelloworld");
        docRef = colRef.document("ycONutzZgAwGr2MRMKd8");
//        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirebaseFirestoreException e) {
//                if (e != null){
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()) {
//
//                    Message msg = snapshot.toObject(Message.class);
//                    tvMessage.setText(msg.getText());
//                    tvPriority.setText("Priority is " + msg.getPriority());
//                }
//            }
//        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString();

                Date boardDate = null;
                try {
                    boardDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String name = etName.getText().toString();
                Integer days = Integer.parseInt(etDays.getText().toString());
                String petType = spnPetType.getSelectedItem().toString();
                Boolean vaccinated = cbVac.isChecked();

                Message msg = new Message(boardDate, name, days, petType, vaccinated);
                docRef.set(msg);
            }
        });


    }

    private void btnSendOnClick(View v) throws ParseException {
//        String text = etMessage.getText().toString();
//        docRef.update("text", text, "color", "red");



    }
}