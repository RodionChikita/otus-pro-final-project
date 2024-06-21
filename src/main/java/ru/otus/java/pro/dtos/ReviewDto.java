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
public class ReviewDto {
    private Long id;
    private Long clientId;
    private String reviewText;
    private byte grade;
    private Date createdAt;
    private Long clientReviewedId;
}
