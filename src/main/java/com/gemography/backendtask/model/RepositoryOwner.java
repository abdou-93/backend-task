package com.gemography.backendtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RepositoryOwner {
    private Integer id;
    private String avatarURL;
}
