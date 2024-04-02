package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.java.pro.entities.Category;
import ru.otus.java.pro.entities.RealEstateType;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RealEstateDto extends Category{
    private Long id;
    private RealEstateType realEstateType;
    private byte numberOfRooms;
    private byte floor;
    private int square;
    private UUID adId;
}
