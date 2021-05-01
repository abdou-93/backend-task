package com.gemography.backendtask.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Repository {
    @ApiModelProperty(dataType = "integer", example = "10")
    private Integer id;

    @ApiModelProperty(dataType = "String", example = "repo")
    private String name;

    @ApiModelProperty(dataType = "String", example = "desc")
    private String description;

    @ApiModelProperty(dataType = "String", example = "java")
    private String language;

    private RepositoryOwner owner;
}
