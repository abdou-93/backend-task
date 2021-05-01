package com.gemography.backendtask.controller;

import com.gemography.backendtask.model.Language;
import com.gemography.backendtask.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/languages")
    public ResponseEntity<Object> getLanguages() throws Exception {
        List<Language> languageList = this.languageService.getAll();
        SuccessResponseObject response = new SuccessResponseObject();
        HttpStatus status = HttpStatus.OK;
        response.setData(languageList);
        response.setStatus(status);
        return new ResponseEntity<>(response, status);
    }
}
