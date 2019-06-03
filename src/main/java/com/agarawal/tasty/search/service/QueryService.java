package com.agarawal.tasty.search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.stereotype.Service;

import com.agarawal.tasty.search.model.Review;
import com.agarawal.tasty.search.model.ReviewIndex;
import com.agarawal.tasty.search.model.TokenStructure;

/**
 *
 * @author Abhishek Agarawal [ hellome.abhi@gmail.com ]
 */
@Service
public class QueryService {

    public List<String> search(String query[]) {
        return search(query, 20);
    }

    public List<String> search(String tokens[], int K) {
        Set<Review> reviews = new TreeSet<>();
        for (String token : tokens) {
            Set<Integer> reviewSet = TokenStructure.getInstance().searchReviews(token);
            if (reviewSet == null || reviewSet.isEmpty()) {
                continue;
            }
            for(int reviewId : reviewSet) {
                Review currentReview = ReviewIndex.getReview(reviewId);
                if(currentReview == null) continue;
                if (reviews.contains(currentReview)) {
                    reviews.remove(currentReview);
                }
                currentReview.queryHit();
                reviews.add(currentReview);
            }
        }
        
        List<String> topReviews = new ArrayList<>(K);
        for (Review review : reviews) {
            if (K-- > 0) {
                topReviews.add(review.getReview());
            } else {
                break;
            }
        }

        ReviewIndex.resetQueryScore();
        
        return topReviews;
    }

}
