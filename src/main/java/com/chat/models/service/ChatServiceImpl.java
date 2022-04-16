package com.chat.models.service;

import com.chat.models.dao.ChatRepository;
import com.chat.models.documents.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository repository;

    @Override
    public List<Message> getLast10messages() {
        return repository.findFirst10ByOrderByDateDesc();
    }

    @Override
    public Message save(Message message) {
        return repository.save(message);
    }
}
