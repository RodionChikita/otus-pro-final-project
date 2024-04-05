package ru.otus.java.pro.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
@Getter
@Setter
@Table("messages")
public class Message {
    @Id
    private Long id;
    private String messageText;
    private Long clientId;
    private Long chatId;
    private Date createdAt;
    @Autowired
    public Message(Long id, String messageText, Long clientId, Date createdAt) {
        this.id = id;
        this.messageText = messageText;
        this.clientId = clientId;
        this.createdAt = createdAt;
    }
}
