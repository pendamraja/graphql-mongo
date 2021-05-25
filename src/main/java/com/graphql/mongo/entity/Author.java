package com.graphql.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Author {

    @Id
    private String id;
    private String name;
    private String age;
}
