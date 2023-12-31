package com.citi.hackathon_backend.document.controller;

import com.citi.hackathon_backend.document.entity.UserDocument;
import com.citi.hackathon_backend.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
@CrossOrigin(origins = "*")
public class DocumentController {
    @Autowired
    DocumentService documentService;
    @PostMapping(value = "/createDocument")
    public UserDocument createDocument(@RequestParam String name,@RequestParam String authenticationId,@RequestParam String createName){
        return documentService.createDocument(name,authenticationId,createName);
    }


    @GetMapping(value = "/getDocumentById")
    public UserDocument getDocumentById(@RequestParam String id){
        return documentService.getDocumentById(id);
    }

    @GetMapping(value = "/getDocument/byname")
    public UserDocument getDocumentByName(@RequestParam String name){
        return documentService.getDocumentByName(name);
    }

    @GetMapping(value = "/getAllDocument")
    public List<UserDocument> getDocuments(){
        return documentService.getDocuments();
    }



}
