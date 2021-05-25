package com.graphql.mongo.service.datafetcher;

import com.graphql.mongo.entity.Book;
import com.graphql.mongo.respository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDataFetcher implements DataFetcher<Book> {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book get(DataFetchingEnvironment environment) throws Exception {
        String id = environment.getArgument("id");
        return bookRepository.findById(id);
    }

}
