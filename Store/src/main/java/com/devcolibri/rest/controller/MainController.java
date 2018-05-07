package com.devcolibri.rest.controller;

import com.devcolibri.rest.domain.Message;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/res")
public class MainController {

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getTest() {
        return new ResponseEntity(new Message("Testing"), HttpStatus.OK);
    }

}
