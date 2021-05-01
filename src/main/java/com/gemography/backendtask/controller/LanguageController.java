package com.gemography.backendtask.controller;

import com.gemography.backendtask.model.Language;
import com.gemography.backendtask.service.LanguageService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value="languages")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    @ApiOperation("Returns list of the languages used by the 100 trending public repos on GitHub.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = LanguageListResponse.class)})
    public ResponseEntity<Object> getLanguages() throws Exception {
        List<Language> languageList = this.languageService.getAll();
        SuccessResponseObject<List<Language>> response = new SuccessResponseObject<>();
        HttpStatus status = HttpStatus.OK;
        response.setData(languageList);
        response.setStatus(status);
        return new ResponseEntity<>(response, status);
    }

    private class LanguageListResponse extends SuccessResponseObject<List<Language>> {}
}
