package com.chat.models.service;

import com.chat.models.documents.Message;

import java.util.List;

public interface ChatService {

     List<Message> getLast10messages();
     Message save(Message message);
}
