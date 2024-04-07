package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import ru.otus.java.pro.entities.CategoryEnum;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdDto {
    private UUID id;
    private String title;
    private Date postingDate;
    private String description;
    private Long price;
    private boolean actuality;
    private String city;
    private String fullAddress;
    private CategoryEnum categoryEnum;
    private Long clientId;
}
