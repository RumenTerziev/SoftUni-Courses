package com.example.springintro.model;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.EditionType;

import java.math.BigDecimal;

public class BookPrintInformation {

    private final String title;
    private final EditionType editionType;
    private final AgeRestriction ageRestriction;
    private final BigDecimal price;

    public BookPrintInformation(String title, EditionType editionType, AgeRestriction ageRestriction, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.title, this.editionType, this.ageRestriction, this.price);
    }


}
