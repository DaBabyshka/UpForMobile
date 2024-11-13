package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddDocumentActivity extends AppCompatActivity {

    private EditText etDocumentType, etApplicantName;
    private Button btnSaveDocument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_document);

        etDocumentType = findViewById(R.id.etDocumentType);
        etApplicantName = findViewById(R.id.etApplicantName);
        btnSaveDocument = findViewById(R.id.btnSaveDocument);

        btnSaveDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String documentType = etDocumentType.getText().toString();
                String applicantName = etApplicantName.getText().toString();

                Document newDocument = new Document(documentType, applicantName);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("document", newDocument); // Теперь работает
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
