package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ViewDocumentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DocumentAdapter documentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_documents);

        recyclerView = findViewById(R.id.recyclerViewDocuments);
        ArrayList<Document> documents = (ArrayList<Document>) getIntent().getSerializableExtra("documents");

        documentAdapter = new DocumentAdapter(documents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(documentAdapter);
    }
}
