package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder> {

    private List<Document> documents;

    public DocumentAdapter(List<Document> documents) {
        this.documents = documents;
    }

    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_document, parent, false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder, int position) {
        Document document = documents.get(position);
        holder.tvDocumentType.setText(document.getDocumentType());
        holder.tvApplicantName.setText(document.getApplicantName());
        holder.tvStatus.setText(document.getStatus());

        // Обработка нажатия на кнопку "Изменить статус"
        holder.btnChangeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentStatus = document.getStatus();
                switch (currentStatus) {
                    case "Ожидание":
                        document.setStatus("В процессе");
                        break;
                    case "В процессе":
                        document.setStatus("Закрыто");
                        break;
                    default:
                        break;
                }
                notifyItemChanged(position); // Обновить отображение элемента
            }
        });

        // Обработка нажатия на кнопку "Закрыть справку"
        holder.btnCloseDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                document.closeDocument();
                notifyItemChanged(position); // Обновить отображение элемента
            }
        });
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    public static class DocumentViewHolder extends RecyclerView.ViewHolder {
        TextView tvDocumentType, tvApplicantName, tvStatus;
        Button btnChangeStatus, btnCloseDocument;

        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDocumentType = itemView.findViewById(R.id.tvDocumentType);
            tvApplicantName = itemView.findViewById(R.id.tvApplicantName);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            btnChangeStatus = itemView.findViewById(R.id.btnChangeStatus);
            btnCloseDocument = itemView.findViewById(R.id.btnCloseDocument);
        }
    }
}
