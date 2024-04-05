package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {
    private Long id;
    private Long clientCustomerId;
    private Long clientSellerId;
    private UUID adId;
    private Date createdAt;
}
