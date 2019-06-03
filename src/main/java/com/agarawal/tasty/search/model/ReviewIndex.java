package com.agarawal.tasty.search.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Abhishek Agarawal [ hellome.abhi@gmail.com ]
 */
public class ReviewIndex {

    private static final Map<Integer, Review> index = new ConcurrentHashMap<>();

    public static void addReview(Review review) {
        index.put(review.getId(), review);
    }
    
    public static Review getReview(int reviewId) {
        return index.get(reviewId);
    }

    public static void resetQueryScore() {
        index.values().forEach((review) -> {
            review.resetQueryScore();
        });
    }

}
