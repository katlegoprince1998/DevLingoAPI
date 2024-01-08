package com.codewoorld.DevLingoAPI.repository;

import com.codewoorld.DevLingoAPI.collection.Lingo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LingoRepository extends MongoRepository<Lingo, String> {
    List<Lingo> findByName(String name); // <1>
}
