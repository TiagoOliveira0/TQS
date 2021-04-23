package com.demo.app;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirRestController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping(path="/air_quality")
    public JSONObject getAirqualitybyLocation(@RequestParam float lat, @RequestParam float lon) {

        JSONObject json = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/air_pollution?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey, JSONObject.class);

        return json;
    }

    @GetMapping(path="/air_quality")
    public JSONObject getAirqualitybyDay(@RequestParam float lat, @RequestParam float lon,@RequestParam int start, @RequestParam int end) {

        JSONObject json = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/air_pollution/history?lat=" + lat + "&lon=" + lon + "&start=" + start + "&end=" + end + "&appid=" + apiKey, JSONObject.class);

        return json;
    }


}
