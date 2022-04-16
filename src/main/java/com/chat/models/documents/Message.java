package com.chat.models.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "mensajes")
@Data
public class Message  implements Serializable {

    @Id
    private String id;
    private String text;
    private Long date;
    private String username;
    private String type;
    private String color;
}
