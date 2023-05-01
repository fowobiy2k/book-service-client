package com.soap.client.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.soap.client.generated.*;

@Service
public class ClientClass {

    @Value("${bookservice.url}")
    private String serviceUrl;

    @Autowired
    private Jaxb2Marshaller marshaller;

    WebServiceTemplate template;

    public CreateBookResponse createBook(CreateBookRequest request){
        template= new WebServiceTemplate(marshaller);
        CreateBookResponse response = (CreateBookResponse) template.marshalSendAndReceive(serviceUrl, request);
        return response;
    }

    public GetBookByIdResponse getBookById(GetBookByIdRequest request){
        template= new WebServiceTemplate(marshaller);
        GetBookByIdResponse response = (GetBookByIdResponse) template.marshalSendAndReceive(serviceUrl, request);
        return response;
    }

    public GetBooksResponse getAllBooks(GetBooksRequest request){
        template= new WebServiceTemplate(marshaller);
        GetBooksResponse response = (GetBooksResponse) template.marshalSendAndReceive(serviceUrl, request);
        return response;
    }
}
