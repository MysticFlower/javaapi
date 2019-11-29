package com.notes.notes.repositories;

import com.notes.notes.models.Notes;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotesRepository extends MongoRepository<Notes, String> {
    Notes findBy_id(ObjectId _id);
}