package com.marg.margpoc.repository;

import com.marg.margpoc.model.Outstanding;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OutstandingRepository extends MongoRepository<Outstanding, String> {

}
