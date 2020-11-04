package com.javelwilson.nyammingsdb.service;

import com.javelwilson.nyammingsdb.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> getRestaurants(int page, int limit);
    RestaurantDto createRestaurant(RestaurantDto newRestaurant);
    RestaurantDto getRestaurant(String restaurantId);
    RestaurantDto updateRestaurant(String restaurantId, RestaurantDto restaurantUpdate);
}
