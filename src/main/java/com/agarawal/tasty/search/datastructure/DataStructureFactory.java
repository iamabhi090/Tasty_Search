package com.agarawal.tasty.search.datastructure;

/**
 *
 * @author Abhishek Agarawal [ hellome.abhi@gmail.com ]
 */
public class DataStructureFactory {
    
    public static enum DataStructureType {
        HASHMAP
    }
    
    public static DataStructure getInstance(DataStructureType type, boolean partialSearch, boolean caseSensitive) {
        switch(type) {
            case HASHMAP: return new HashMap(partialSearch, caseSensitive);
            default: return null;
        }
    }
    
}
