package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateReviewDtoRq {
    private Long clientId;
    private String reviewText;
    private byte grade;
    private Long clientReviewedId;
}
