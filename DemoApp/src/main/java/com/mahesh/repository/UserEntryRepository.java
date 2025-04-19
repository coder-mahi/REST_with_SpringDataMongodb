package com.mahesh.repository;

import org.bson.types.ObjectId;
import com.mahesh.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepository extends MongoRepository<User,ObjectId> {

}
