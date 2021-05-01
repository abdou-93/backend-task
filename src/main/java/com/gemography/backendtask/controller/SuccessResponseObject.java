package com.gemography.backendtask.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
public class SuccessResponseObject {
    private Long timestamp;
    private HttpStatus status;
    private Object data;

    public SuccessResponseObject() {
        timestamp = Instant.now().toEpochMilli();
        status = HttpStatus.OK;
    }
}
