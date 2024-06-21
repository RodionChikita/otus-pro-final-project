package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long id;
    private String messageText;
    private Long clientId;
    private Long chatId;
    private Date createdAt;
}
