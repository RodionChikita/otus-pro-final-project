package ru.otus.java.pro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RealEstateType {
    FLAT("FLAT"), HOSE("HOSE");
    private String name;
}
