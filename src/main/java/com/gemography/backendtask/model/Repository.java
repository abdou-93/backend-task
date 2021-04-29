package com.gemography.backendtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Repository {
    private Integer id;
    private String name;
    private String description;
    private String language;
    private RepositoryOwner owner;
}
