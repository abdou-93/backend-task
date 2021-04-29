package com.gemography.backendtask.model.github;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryResponse {
    private int id;
    private String name;
    private String description;
    private String languages_url;
    private String language;
    private RepositoryOwnerResponse owner;
}
