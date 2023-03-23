package com.ms.base.controller;

import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Backoff;
@RestController
public class AadaarAPI {
	
	@Retryable(maxAttempts = 8, backoff = @Backoff(delay = 1000))
	@GetMapping({ "/sagachoreographer" })
	public String callAadhaarApi(@RequestParam("aadahaarno") String aadahaarno) {
 
		RestTemplate restTemplate = new RestTemplate();

        // Set the URL of the API endpoint you want to call
        String apiUrl = "http://107.155.116.31:1357/validateAadaarGet";

        Map<String, String> params = Collections.singletonMap("aadahaarno", "111111");
       // params.put("name", "Alice");
        // Perform the GET request and deserialize the response into a Todo object
        String todo = restTemplate.getForObject(apiUrl, String.class,params);

        // Print out the response
        System.out.println(todo);
        return todo;
	}
	@Retryable(maxAttempts = 8, backoff = @Backoff(delay = 1000))
	@GetMapping({ "/sagachoreographer1" })
	public String callAadhaarApi1(@RequestParam("aadahaarno") String aadahaarno) {
 
		RestTemplate restTemplate = new RestTemplate();

        // Set the URL of the API endpoint you want to call
        String apiUrl = "http://localhost:1357/validateAadaarGet";

        Map<String, String> params = Collections.singletonMap("aadahaarno", "111111");
       // params.put("name", "Alice");
        // Perform the GET request and deserialize the response into a Todo object
        String todo = restTemplate.getForObject(apiUrl, String.class,params);

        // Print out the response
        System.out.println(todo);
        return todo;
	}

}
