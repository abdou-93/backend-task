package com.gemography.backendtask.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Language {
    @ApiModelProperty(dataType = "String", example = "java")
    private String name;

    @ApiModelProperty(dataType = "integer", example = "10")
    private int numberOfRepos;

    private List<Repository> repositoryList = new ArrayList<>();

    public Language(String name) {
        this.name = name;
        this.repositoryList = new ArrayList<>();
    }

    public void addRepository(Repository repository) {
        if (!repositoryList.contains(repository)) {
            repositoryList.add(repository);
            numberOfRepos++;
        }
    }

    public void setRepositoryList(List<Repository> repositoryList) {
        if (repositoryList != null) {
            this.repositoryList = repositoryList;
            numberOfRepos = this.repositoryList.size();
        } else {
            this.repositoryList = new ArrayList<>();
            numberOfRepos = 0;
        }
    }
}
