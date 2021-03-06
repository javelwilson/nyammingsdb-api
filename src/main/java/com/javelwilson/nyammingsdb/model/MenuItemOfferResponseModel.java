package com.javelwilson.nyammingsdb.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuItemOfferResponseModel {
    private String offerId;

    private String name;

    private BigDecimal price;

    private String description;

    private String type;

    private Boolean required;
}
