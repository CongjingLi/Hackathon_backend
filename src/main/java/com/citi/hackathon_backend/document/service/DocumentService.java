package com.citi.hackathon_backend.document.service;

import com.citi.hackathon_backend.document.entity.UserDocument;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DocumentService {
     public UserDocument createDocument(String name, String authenticationId, String createName);
    public UserDocument getDocumentById(String id);
    public UserDocument getDocumentByName(String name);
    public List<UserDocument> getDocuments();
}
