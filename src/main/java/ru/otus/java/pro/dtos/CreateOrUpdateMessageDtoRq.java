package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateMessageDtoRq {
    private String messageText;
    private Long clientId;
    private Long chatId;
}
