package com.khlin.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FilterRestaurantsByVeganFriendlyPriceAndDistance_1333 {

    // id rating veganFriendly  price  distance
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> filteredRestaurants = new ArrayList<>(restaurants.length);
        for (int rowIndex = 0; rowIndex <= restaurants.length - 1; rowIndex++) {
            int[] restaurantItr = restaurants[rowIndex];
            if (1 == veganFriendly) {
                if (1 != restaurantItr[2]) {
                    continue;
                }
            }

            if (restaurantItr[3] > maxPrice || restaurantItr[4] > maxDistance) {
                continue;
            }

            filteredRestaurants.add(restaurantItr);
        }

        if (!filteredRestaurants.isEmpty()) {
            Collections.sort(filteredRestaurants, (r1, r2) -> {
                if (r2[1] - r1[1] == 0) {
                    return r2[0] - r1[0];
                }

                return r2[1] - r1[1];
            });
            return filteredRestaurants.stream().map(r -> r[0]).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
