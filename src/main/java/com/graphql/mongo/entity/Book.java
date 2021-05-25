package com.graphql.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "Book")
public class Book {
    @Id
    private String id;
    private String name;
    private String publisher;
    private Author author;
    private String publishedDate;

}
