package com.gemography.backendtask.service;

import com.gemography.backendtask.model.Repository;
import com.gemography.backendtask.model.RepositoryOwner;
import com.gemography.backendtask.model.github.RepositoriesResponse;
import com.gemography.backendtask.model.github.RepositoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryDataService {

    private String url = "https://api.github.com/search/repositories?q=created:>2020-04-28&sort=stars&order=desc&per_page=100";

    public List<Repository> getAll() {
        List<Repository> repositoryList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        try {
            RepositoriesResponse repositoriesResponse = restTemplate.getForObject(url, RepositoriesResponse.class);
            if (repositoriesResponse != null) {
                List<RepositoryResponse> repos = repositoriesResponse.getItems();
                if (repos != null) {
                    for (RepositoryResponse repo : repos) {
                        repositoryList.add(getRepository(repo));
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return repositoryList;
    }

    private Repository getRepository(RepositoryResponse response) {
        Repository repository = new Repository();
        if (response != null) {
            RepositoryOwner owner = new RepositoryOwner();
            repository.setId(response.getId());
            repository.setName(response.getName());
            repository.setDescription(response.getDescription());
            repository.setLanguage(response.getLanguage());

            // update owner
            if (response.getOwner() != null) {
                owner.setId(response.getOwner().getId());
                owner.setAvatarURL(response.getOwner().getAvatar_url());
                repository.setOwner(owner);
            }
        }
        return  repository;
    }
}
