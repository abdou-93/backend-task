package com.gemography.backendtask.model.github;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoriesResponse {
    private int total_count;
    private boolean incomplete_results;
    private List<RepositoryResponse> items;
}
