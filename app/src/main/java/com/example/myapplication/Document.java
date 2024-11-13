package com.example.myapplication;

import java.io.Serializable;

public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    private String documentType;
    private String applicantName;
    private String status;

    public Document(String documentType, String applicantName) {
        this.documentType = documentType;
        this.applicantName = applicantName;
        this.status = "Ожидание";
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!this.status.equals("Закрыто")) { // Не изменять, если документ уже закрыт
            this.status = status;
        }
    }

    public void closeDocument() {
        this.status = "Закрыто";
    }
}
