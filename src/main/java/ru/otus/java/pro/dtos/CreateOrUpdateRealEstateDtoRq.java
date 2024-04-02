package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.java.pro.entities.Category;
import ru.otus.java.pro.entities.RealEstateType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateRealEstateDtoRq extends Category {
    private RealEstateType realEstateType;
    private byte numberOfRooms;
    private byte floor;
    private int square;
}
