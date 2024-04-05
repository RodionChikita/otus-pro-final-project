package ru.otus.java.pro.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Getter
@Setter
@Table("reviews")
public class Review {
    @Id
    private Long id;
    private Long clientId;
    private String reviewText;
    private byte grade;
    private Date createdAt;
    private Long clientReviewedId;

    @PersistenceCreator
    public Review(Long id, Long clientId, String reviewText, byte grade, Date createdAt, Long clientReviewedId) {
        this.id = id;
        this.clientId = clientId;
        this.reviewText = reviewText;
        this.grade = grade;
        this.createdAt = createdAt;
        this.clientReviewedId = clientReviewedId;
    }
}
