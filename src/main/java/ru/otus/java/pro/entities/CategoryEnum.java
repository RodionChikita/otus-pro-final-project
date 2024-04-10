package ru.otus.java.pro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryEnum {
    REAL_ESTATE("REAL_ESTATE"), SHOES("SHOES");
    private String name;
}
