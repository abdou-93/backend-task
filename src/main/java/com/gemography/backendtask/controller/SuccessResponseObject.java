package com.gemography.backendtask.controller;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
public class SuccessResponseObject<T> {
    @ApiModelProperty(dataType = "integer", example = "5123123123")
    private Long timestamp;

    @ApiModelProperty(dataType = "string", example = "ok")
    private HttpStatus status;

    private T data;

    public SuccessResponseObject() {
        timestamp = Instant.now().toEpochMilli();
        status = HttpStatus.OK;
    }
}
