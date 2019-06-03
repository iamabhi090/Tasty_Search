package com.agarawal.tasty.search.datastructure;

import java.util.Set;

/**
 *
 * @author Abhishek Agarawal [ hellome.abhi@gmail.com ]
 */
public abstract class DataStructure {
    
    protected final boolean partialSearch;
    protected final boolean caseSensitive;
    
    protected DataStructure(boolean partialSearch, boolean caseSensitive) {
        this.partialSearch = partialSearch;
        this.caseSensitive = caseSensitive;
    }
    
    public abstract void addToken(int reviewId, String token);
    
    public abstract Set<Integer> searchToken(String token);
    
    public abstract void display();
    
}
