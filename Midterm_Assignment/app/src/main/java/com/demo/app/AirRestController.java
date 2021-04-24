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
import java.util.List;

@RestController
public class AirRestController {

    @Autowired
    private AirQualityService airQualityService;

    @GetMapping(path="/")
    public String getHomePage(){
        return "HomePage";
    }

    @GetMapping(path="/now")
    public String getAirqualitybyLocation(@RequestParam float lat, @RequestParam float lon, Model model ){
        model.addAttribute("Air", airQualityService.getAirByNow(lat, lon));
        return "AirQualityNow";
    }

    @GetMapping(path="/byday")
    public String getAirqualitybyDay(@RequestParam float lat, @RequestParam float lon, @RequestParam int start, @RequestParam int end, Model model){
        try {
            model.addAttribute("List<Air>", airQualityService.getAirByDay(lat,lon,start,end));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "AirQualityDays";
    }

    @GetMapping(path="/AirQuality/now")
    public ResponseEntity<Air> getAirqualitybyLocationAPI(@RequestParam float lat, @RequestParam float lon){
        Air air = airQualityService.getAirByNow(lat,lon);

        return new ResponseEntity<Air>(air,HttpStatus.OK);
    }

    @GetMapping(path="/AirQuality/byday")
    public ResponseEntity<List<Air>> getAirqualitybyDayAPI(@RequestParam float lat, @RequestParam float lon, @RequestParam int start, @RequestParam int end){
        List<Air> air = null;
        try {
            air = airQualityService.getAirByDay(lat,lon,start,end);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(air == null)
            return new ResponseEntity<List<Air>>(air,HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Air>>(air,HttpStatus.OK);
    }


}

