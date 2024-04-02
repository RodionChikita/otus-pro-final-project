package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.MappedCollection;
import ru.otus.java.pro.entities.Category;
import ru.otus.java.pro.entities.CategoryEnum;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateAdDtoRq<T extends Category> {
    private String title;
    private String description;
    private Long price;
    private String city;
    private String fullAddress;
    private CategoryEnum categoryEnum;
    private T category;
    private Long clientId;
}
