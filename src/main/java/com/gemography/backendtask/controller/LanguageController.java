package com.gemography.backendtask.controller;

import com.gemography.backendtask.model.Language;
import com.gemography.backendtask.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public SuccessResponseObject getLanguages() throws Exception {
        SuccessResponseObject response = new SuccessResponseObject();
        List<Language> languageList = this.languageService.getAll();
        response.setData(languageList);
        return response;
    }
}
