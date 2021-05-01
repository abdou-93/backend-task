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
public class RepositoryOwner {
    @ApiModelProperty(dataType = "integer", example = "5")
    private Integer id;

    @ApiModelProperty(dataType = "String", example = "https://avatars.githubusercontent.com/u/64886238?v=4")
    private String avatarURL;
}
