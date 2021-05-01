package com.gemography.backendtask.service;

import com.gemography.backendtask.exception.ThirdPartyException;
import com.gemography.backendtask.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private LanguageDataService languageDataService;

    @Autowired
    public LanguageService(LanguageDataService languageDataService) {
        this.languageDataService = languageDataService;
    }

    public List<Language> getAll() throws ThirdPartyException {
        return languageDataService.getAll();
    }
}
