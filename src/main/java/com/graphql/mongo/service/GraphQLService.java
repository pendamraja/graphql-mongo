package com.graphql.mongo.service;

import com.graphql.mongo.entity.Book;
import com.graphql.mongo.respository.BookRepository;
import com.graphql.mongo.service.datafetcher.AllBooksDataFetcher;
import com.graphql.mongo.service.datafetcher.BookDataFetcher;
import com.graphql.mongo.service.datafetcher.BooknameDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQLService {

    @Autowired
    BookRepository bookRepository;
    @Value("classpath:books.graphql")
    Resource resource;
    private GraphQL graphQL;
    private GraphQLSchema schema;
    @Autowired
    private AllBooksDataFetcher allBooksDataFetcher;
    @Autowired
    private BookDataFetcher bookDataFetcher;
    @Autowired
    BooknameDataFetcher findbookByname;

    @PostConstruct
    private void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }
    public Book saveData(Book book) {
         return bookRepository.save(book);
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("findallBooks", allBooksDataFetcher)
                        .dataFetcher("findbook", bookDataFetcher)
                        .dataFetcher("findbookByname",findbookByname)).build();
                            }
    public GraphQL getGraphQL() {
        return graphQL;
    }
}
