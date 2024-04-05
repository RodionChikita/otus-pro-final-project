package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.java.pro.entities.CategoryEnum;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateAdDtoRq {
    private String title;
    private String description;
    private Long price;
    private String city;
    private String fullAddress;
    private CategoryEnum categoryEnum;
    private Long clientId;
}
