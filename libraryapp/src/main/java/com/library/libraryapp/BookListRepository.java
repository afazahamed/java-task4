package com.library.libraryapp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListRepository extends MongoRepository<BookListModel, Integer> {

}
