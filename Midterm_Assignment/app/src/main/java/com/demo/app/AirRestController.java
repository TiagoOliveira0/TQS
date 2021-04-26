package com.demo.app;

import org.apache.coyote.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.AttributedString;
import java.time.Instant;
import java.util.List;

@RestController
public class AirRestController {

    @Autowired
    private AirQualityService airQualityService;

    @Autowired
    private AirQualityGeoLocationService airQualityServiceGeoLocationService;

    @GetMapping(path="/")
    public String getHomePage(){
        return "HomePage";
    }

    @GetMapping(path="/now")
    public String getAirqualitybyLocation(@RequestParam float lat, @RequestParam float lon, Model model ){
        model.addAttribute("Air", airQualityService.getAirByNow(lat, lon));
        return "AirQualityNow";
    }

    @GetMapping(path="/next")
    public String getAirqualityNextDays(@RequestParam float lat, @RequestParam float lon, Model model){
        model.addAttribute("List<Air>", airQualityService.getAirNextDays(lat,lon));
        return "AirQualityNextDays";
    }

    @GetMapping(path="/last")
    public String getAirqualityLastDays(@RequestParam float lat, @RequestParam float lon, Model model){
        model.addAttribute("List<Air>", airQualityService.getAirLastDays(lat,lon));
        return "AirQualityLastDays";
    }

    @GetMapping(path="/AirQuality/now")
    public ResponseEntity<Air> getAirqualitybyLocationAPI(@RequestParam float lat, @RequestParam float lon){
        Air air = airQualityService.getAirByNow(lat,lon);

        if(air == null)
            return new ResponseEntity<Air>(air,HttpStatus.NOT_FOUND);

        return new ResponseEntity<Air>(air,HttpStatus.OK);
    }

    @GetMapping(path="/AirQuality/next")
    public ResponseEntity<List<Air>> getAirqualityNextDaysAPI(@RequestParam float lat, @RequestParam float lon){
        List<Air> air = null;

        air = airQualityService.getAirNextDays(lat,lon);

        if(air.size()==0)
            return new ResponseEntity<List<Air>>(air,HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Air>>(air,HttpStatus.OK);
    }

    @GetMapping(path="/AirQuality/last")
    public ResponseEntity<List<Air>> getAirqualityLastDaysAPI(@RequestParam float lat, @RequestParam float lon){
        List<Air> air = null;


        air = airQualityService.getAirLastDays(lat,lon);

        if(air.size()==0)
            return new ResponseEntity<List<Air>>(air,HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Air>>(air,HttpStatus.OK);
    }

    @GetMapping(path="/AirQuality/geo")
    public ResponseEntity<City> getGeoLocationbyCityAPI(@RequestParam String city){
        City c = airQualityServiceGeoLocationService.getCoordsByCity(city);

        if(c == null)
            return new ResponseEntity<City>(c,HttpStatus.NOT_FOUND);

        return new ResponseEntity<City>(c,HttpStatus.OK);
    }


}

