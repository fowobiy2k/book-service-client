package com.soap.client.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soap.client.client.ClientClass;
import com.soap.client.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CoreController {

    Logger logger = LoggerFactory.getLogger(CoreController.class);

    @Autowired
    private ClientClass client;

    @PostMapping("/create")
    public CreateBookResponse createBook(@RequestBody CreateBookRequest request){

        CreateBookResponse response = client.createBook(request);

        logger.info(response.toString());
        return response;
    }

    @GetMapping("/getbook/{id}")
    public GetBookByIdResponse getBookById(GetBookByIdRequest request){

        GetBookByIdResponse response = client.getBookById(request);

        logger.info(response.toString());
        return response;
    }

    @GetMapping("/getbooks")
    public GetBooksResponse getBooks(GetBooksRequest request){
        GetBooksResponse response= client.getAllBooks(request);

        logger.info("response from back service: {}", response.getBooks().toString());
        return response;
    }
}
