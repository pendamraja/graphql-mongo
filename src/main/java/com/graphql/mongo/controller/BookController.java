package com.graphql.mongo.controller;

import com.graphql.mongo.entity.Book;
import com.graphql.mongo.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/BookStore/v1")
@RestController
public class BookController {

    @Autowired
    GraphQLService graphQLService;

    @PostMapping("/insertbooks")
    public Book addBook(@RequestBody Book book) {
        return graphQLService.saveData(book);

    }

    @PostMapping
    public ResponseEntity<Object> getAllBooks(@RequestBody String quey)
    {
        ExecutionResult execute = graphQLService.getGraphQL().execute(quey);
        return new ResponseEntity<>(execute, HttpStatus.OK);
            }
}
