package com.demo.app;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AirControllerApiTest {
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Test
    public void givenCoords_whenGetAirQuality_thenReturnsJSON() throws ParseException {
        String s = "{\"coord\":{\"lon\":-8.5745,\"lat\":41.0232},\"list\":[{\"main\":{\"aqi\":2},\"components\":{\"co\":205.28,\"no\":0.52,\"no2\":2.72,\"o3\":80.11,\"so2\":1.22,\"pm2_5\":0.85,\"pm10\":1.16,\"nh3\":1.58},\"dt\":1619182800}]}";
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(s);

        String lat = "41.0232";
        String lon = "-8.5745";
        ResponseEntity<JSONObject> response = restTemplate
                .exchange("http://api.openweathermap.org/data/2.5/air_pollution/history?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey, HttpMethod.GET, null, new ParameterizedTypeReference<JSONObject>() {
                });

        assertThat(response.getBody()).equals(json);

    }

}

