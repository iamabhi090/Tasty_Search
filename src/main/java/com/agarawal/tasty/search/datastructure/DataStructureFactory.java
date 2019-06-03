package com.agarawal.tasty.search.datastructure;

/**
 *
 * @author Abhishek Agarawal [ hellome.abhi@gmail.com ]
 */
public class DataStructureFactory {
    
    public static enum DataStructureType {
        TRIE,
        HASHMAP
    }
    
    public static DataStructure getInstance(DataStructureType type, boolean partialSearch, boolean caseSensitive) {
        switch(type) {
            case TRIE: return new Trie(partialSearch, caseSensitive);
            case HASHMAP: return new HashMap(partialSearch, caseSensitive);
            default: return null;
        }
    }
    
}
