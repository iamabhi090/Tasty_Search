package com.agarawal.tasty.search.reviewloader;

/**
 *
 * @author Abhishek Agarawal [ hellome.abhi@gmail.com ]
 */
public class ReviewLoaderFactory {
    
    public enum ReviewLoaderType {
        MAPPED_BYTE_BUFFER
    }
    
    public static ReviewLoader getInstance(ReviewLoaderType type) {
        switch(type) {
            case MAPPED_BYTE_BUFFER:
                return new MappedByteBufferReviewLoader();
            default: return null;
        }
    }
    
}
