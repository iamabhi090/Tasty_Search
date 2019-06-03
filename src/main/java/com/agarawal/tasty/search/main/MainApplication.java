package com.agarawal.tasty.search.main;

import com.agarawal.tasty.search.config.Configuration;
import com.agarawal.tasty.search.reviewloader.ReviewLoader;
import com.agarawal.tasty.search.reviewloader.ReviewLoaderFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Abhishek Agarawal [ hellome.abhi@gmail.com ]
 */
@SpringBootApplication(scanBasePackages = {"com.agarawal.tasty.search.controller", "com.agarawal.tasty.search.service"})
public class MainApplication {

    public static void main(String args[]) {
        try {
            // 0. Load Configurations from 'application.properties'
            Configuration.loadConfig();

            // 1. Load Reviews
            ReviewLoader reviewLoader = ReviewLoaderFactory.getInstance(ReviewLoaderFactory.ReviewLoaderType.MAPPED_BYTE_BUFFER);
            reviewLoader.loadReviews(Configuration.getProperty("review.file"), Configuration.getPropertyInteger("sample.data.limit"));

            // 2. Start REST API
            SpringApplication.run(MainApplication.class, args);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error Occurred: " + ex.getMessage());
            System.exit(-1);
        }
    }

}
