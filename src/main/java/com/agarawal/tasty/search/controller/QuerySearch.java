package com.agarawal.tasty.search.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agarawal.tasty.search.service.QueryService;

/**
 *
 * @author Abhishek Agarawal [ hellome.abhi@gmail.com ]
 */
@Controller
public class QuerySearch {

    @Autowired
    private QueryService service;

    @GetMapping(
            value = "/search",
            produces = {"application/json"}
    )
    public @ResponseBody
    List<String> search(@RequestParam("query") String query) {
        return search(query, 20);
    }

    @PostMapping(
            value = "/searchPost",
            consumes = {"text/plain"},
            produces = {"application/json"}
    )
    public @ResponseBody
    List<String> searchPost(@RequestBody String query) {
        return search(query, 20);
    }
    
    public @ResponseBody
    List<String> search(@RequestParam("query") String query, @PathVariable int K) {
        return service.search(query.split("\\W+"));
    }

}
