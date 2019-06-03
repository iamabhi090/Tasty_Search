package com.agarawal.tasty.search.model;

import java.util.Set;

import com.agarawal.tasty.search.datastructure.DataStructure;
import com.agarawal.tasty.search.datastructure.DataStructureFactory;

/**
 *
 * @author Abhishek Agarawal [ hellome.abhi@gmail.com ]
 */
public class TokenStructure {

    private volatile static TokenStructure structure;
    private final DataStructure root;

    private TokenStructure() {
        this.root = DataStructureFactory.getInstance(DataStructureFactory.DataStructureType.HASHMAP, false, false);
    }

    public static TokenStructure getInstance() {
        if (structure == null) {
            synchronized (TokenStructure.class) {
                if (structure == null) {
                    structure = new TokenStructure();
                }
            }
        }
        return structure;
    }

    public void addReview(int reviewId, Set<String> tokens) {
        tokens.forEach((token) -> {
            root.addToken(reviewId, token);
        });
    }

    public Set<Integer> searchReviews(String token) {
        return root.searchToken(token);
    }

    public void display() {
        root.display();
    }

}
