package com.chat.controllers;


import com.chat.models.documents.Message;
import com.chat.models.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private SimpMessagingTemplate webSocket;

    private String[] colors = {"red", "green", "blue", "magenta", "purple", "oranga" };

    @MessageMapping("/mensage")
    @SendTo("/chat/mensage")
    public Message getMessage(Message message){

        message.setDate(new Date().getTime());

        if(message.getType().equals("NUEVO_USUARIO")){
            message.setColor(colors[new Random().nextInt(colors.length)]);
            message.setText("nuevo usuario");
        }else{
            chatService.save(message);
        }

        return message;
    }

    @MessageMapping("/escribiendo")
    @SendTo("/chat/escribiendo")
    public String areWriting(String username){
        return username.concat(" esta escribiendo...");
    }


    @MessageMapping("/historial")
    public void  record(String clientId){
        webSocket.convertAndSend("/chat/historial/"+clientId, chatService.getLast10messages());
    }

}
