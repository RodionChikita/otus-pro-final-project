package ru.otus.java.pro.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Table("chats")
public class Chat {
    @Id
    private Long id;
    private Long clientCustomerId;
    private Long clientSellerId;
    private UUID adId;
    private Date createdAt;
    @MappedCollection(idColumn = "chat_id")
    private Set<Message> messages;

    @PersistenceCreator
    public Chat(Long id, Long clientCustomerId, Long clientSellerId, UUID adId, Date createdAt, Set<Message> messages) {
        this.id = id;
        this.clientCustomerId = clientCustomerId;
        this.clientSellerId = clientSellerId;
        this.adId = adId;
        this.createdAt = createdAt;
        this.messages = messages;
    }
}
