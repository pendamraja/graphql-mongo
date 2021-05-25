package com.graphql.mongo.respository;

import com.graphql.mongo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    MongoTemplate mongoTemplate;


    public Book save(Book book) {
        return mongoTemplate.save(book);
    }

    public List<Book> findAll() {
        return mongoTemplate.findAll(Book.class);
    }

    public Book findById(String id) {
        return mongoTemplate.findById(id,Book.class);
    }

    public Book findByBookname(String name) {
        Query query = new Query(Criteria.where("name").regex("^"+name));
        return mongoTemplate.findOne(query,Book.class);
    }
}
