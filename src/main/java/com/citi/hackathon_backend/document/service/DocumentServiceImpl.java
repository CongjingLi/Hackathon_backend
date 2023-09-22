package com.citi.hackathon_backend.document.service;

import com.citi.hackathon_backend.document.DocumentRepository;
import com.citi.hackathon_backend.document.entity.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{
    private SimpleDateFormat SDF = new SimpleDateFormat("HH:mm dd-MM-yyyy");
    @Autowired
    DocumentRepository documentRepository;
    @Override
    public UserDocument createDocument(String name, String authenticationId, String createName) {
        UserDocument userDocument=new UserDocument();
        userDocument.setCreateUserName(createName);
        userDocument.setAuthenticationId(authenticationId);
        userDocument.setName(name);
        userDocument.setEventList(new ArrayList<>());
        userDocument.setCurrentEventPosition(0);
        userDocument.setCreateTime(SDF.format(new Date()));
        documentRepository.save(userDocument);
        return userDocument;
    }

    @Override
    public UserDocument getDocumentById(String id) {
        return documentRepository.findById(id).get();
    }

    @Override
    public UserDocument getDocumentByName(String name) {
        return documentRepository.findByName(name);
    }

    @Override
    public List<UserDocument> getDocuments() {
        return (List<UserDocument>) documentRepository.findAll();
    }
}
