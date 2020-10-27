package com.javelwilson.nyammingsdb.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "restaurants")
public class RestaurantEntity implements Serializable {

    private static final long serialVersionUID = -3165411496179580749L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String logo;

    private int rating;
}