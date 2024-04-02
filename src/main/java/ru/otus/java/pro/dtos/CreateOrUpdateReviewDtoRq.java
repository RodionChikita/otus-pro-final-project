package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
