package com.gemography.backendtask.controller;

import com.gemography.backendtask.exception.ThirdPartyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String INVALID_REQUEST = "Invalid request";
    public static final String NOT_FOUND_REQUEST = "Not Found request";
    public static final String SERVICE_UNAVAILABLE_REQUEST = "Service Unavailable";
    private static final String PATH = "path";
    private static final String ERRORS = "error";
    private static final String STATUS = "status";
    private static final String MESSAGE = "message";
    private static final String TIMESTAMP = "timestamp";
    private static final String TYPE = "type";

    @ExceptionHandler({ThirdPartyException.class})
    public ResponseEntity<Object> handleThirdPartyError(ThirdPartyException exception, WebRequest request) {
        System.err.println(exception.getMessage());
        System.err.println(exception.getLocalizedMessage());
        return getExceptionResponseEntity(exception, HttpStatus.SERVICE_UNAVAILABLE, request, null);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);
        final HttpStatus status = responseStatus != null ? responseStatus.value() : HttpStatus.INTERNAL_SERVER_ERROR;
        final String localizedMessage = exception.getLocalizedMessage();
        final String path = request.getDescription(false);
        String message = (!isEmpty(localizedMessage) ? localizedMessage : status.getReasonPhrase());
        return getExceptionResponseEntity(exception, status, request, Collections.singletonList(message));
    }

    private ResponseEntity<Object> getExceptionResponseEntity(final Exception exception,
                                                              final HttpStatus status,
                                                              final WebRequest request,
                                                              final List<String> errors) {
        final Map<String, Object> body = new LinkedHashMap<>();
        final String path = request.getDescription(false);
        body.put(TIMESTAMP, Instant.now().toEpochMilli());
        body.put(STATUS, status.value());
        body.put(ERRORS, errors);
        body.put(TYPE, exception.getClass().getSimpleName());
        body.put(PATH, path);
        body.put(MESSAGE, getMessageForStatus(status));
        return new ResponseEntity<>(body, status);
    }

    private String getMessageForStatus(HttpStatus status) {
        switch (status) {
            case NOT_FOUND:
                return NOT_FOUND_REQUEST;
            case BAD_REQUEST:
                return INVALID_REQUEST;
            case SERVICE_UNAVAILABLE:
                return SERVICE_UNAVAILABLE_REQUEST;
            default:
                return status.getReasonPhrase();
        }
    }

    private boolean isEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isEmpty(List<String> list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }
}
