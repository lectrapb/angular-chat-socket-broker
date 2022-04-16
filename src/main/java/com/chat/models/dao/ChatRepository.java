package com.chat.models.dao;

import com.chat.models.documents.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Message, String> {

    public List<Message> findFirst10ByOrderByDateDesc();
}
