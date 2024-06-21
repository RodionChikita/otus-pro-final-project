package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateShoesDtoRq extends CreateOrUpdateAdDtoRq {
    private byte size;
    private String brand;
}
