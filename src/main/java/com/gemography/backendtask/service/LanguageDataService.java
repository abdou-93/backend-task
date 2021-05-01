package com.gemography.backendtask.service;

import com.gemography.backendtask.exception.ThirdPartyException;
import com.gemography.backendtask.model.Language;
import com.gemography.backendtask.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LanguageDataService {

    private RepositoryDataService repositoryDataService;

    @Autowired
    public LanguageDataService(RepositoryDataService repositoryDataService) {
        this.repositoryDataService = repositoryDataService;
    }

    public List<Language> getAll() throws ThirdPartyException {
        Map<String, Language> languageMap = new HashMap<>();
        List<Language> allLanguage = new ArrayList<>();
        List<Repository> repositoryList = repositoryDataService.getAll();
        if (repositoryList != null) {
            for (Repository repository : repositoryList) {
                String language = repository.getLanguage();
                if (language != null) {
                    if (languageMap.containsKey(language)) {
                        languageMap.get(language).addRepository(repository);
                    } else {
                        Language newLanguage = new Language(language);
                        newLanguage.addRepository(repository);
                        languageMap.put(language, newLanguage);
                    }
                }
            }
        }

        for (Map.Entry<String, Language> entry : languageMap.entrySet()) {
            allLanguage.add(entry.getValue());
        }

        return allLanguage;
    }
}
