package com.gemography.backendtask.model.github;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryOwnerResponse {
    private int id;
    private String avatar_url;
}
