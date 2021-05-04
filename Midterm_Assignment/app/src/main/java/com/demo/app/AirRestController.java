package com.demo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class AirRestController {

    Logger logger = LoggerFactory.getLogger(AirRestController.class);

    @Autowired
    private AirQualityService airQualityService;

    @Autowired
    private AirQualityGeoLocationService airQualityGeoLocationService;

    private Cache cache1 = new Cache();

    private Cache cache2 = new Cache();

    private Cache cache3 = new Cache();

    @GetMapping("/")
    public String getHomePage(){
        logger.info("Home page was accessed.");
        return "HomePage";
    }

    @GetMapping(path="/now")
    public String getAirqualitybyLocation(@RequestParam String city, Model model ){
        City c = null;
        if(cache1.containsCity(city)){
            if(cache1.containsInfo(city)){
                logger.info("Air pollution about today for the city " + city + " accessed via cache because it was already requested less then " + TimeUnit.SECONDS.convert(cache1.getAvg(), TimeUnit.NANOSECONDS) + "s ago.");
                model.addAttribute("Air",cache1.getValue(city).get(0));
                return "AirQualityNow";
            }
            logger.info("Coordinates for the place called " + city + " were accessed via cache.");
            c = cache1.getCity(city);
        }

        if(c==null)
            c = airQualityGeoLocationService.getCoordsByCity(city);

        if(city!=null && c!=null){
            Air air = airQualityService.getAirByNow(c);
            Map<City, List<Air>> res = new HashMap<>();
            List<Air> lista = new ArrayList<>();
            lista.add(air);
            res.put(c,lista);
            cache1.add(res);
            logger.info("AirQualityNow page was accessed to show the air pollution at the moment for the place " + city + ".");
            logger.info("Air pollution about today for the place called " + c.getCity() + " was cached for the next " + TimeUnit.SECONDS.convert(cache1.getAvg(), TimeUnit.NANOSECONDS) + "s.");
            model.addAttribute("Air", air);
            return "AirQualityNow";
        }
        else{
            logger.error("No city was found.");
            return "ErrorPage";
        }

    }

    @GetMapping(path="/next")
    public String getAirqualityNextDays(@RequestParam String city, Model model){
        City c = null;
        if(cache2.containsCity(city)){
            if(cache2.containsInfo(city)){
                logger.info("Air pollution about the next 5 days for the city " + city + " accessed via cache because it was already requested less then " + TimeUnit.SECONDS.convert(cache1.getAvg(), TimeUnit.NANOSECONDS) + "s ago.");
                model.addAttribute("Air", cache2.getValue(city));
                return "AirQualityNext";
            }
            logger.info("Coordinates for the place called " + city + " were accessed via cache.");
            c = cache2.getCity(city);
        }

        if(c == null)
            c = airQualityGeoLocationService.getCoordsByCity(city);

        if(city!=null && c!=null){
            Map<City,List<Air>> res = new HashMap<>();
            logger.info("AirQualityNext page was accessed to show the air pollution about the next 5 days for the place " + city + ".");

            List<Air> lista = airQualityService.getAirNextDays(c);

            res.put(c,lista);
            cache2.add(res);
            logger.info("Air pollution about the next 5 days for the place called " + c.getCity() + " was cached for the next " + TimeUnit.SECONDS.convert(cache2.getAvg(), TimeUnit.NANOSECONDS) + "s.");
            model.addAttribute("Air", lista);
            return "AirQualityNext";
        }
        else{
            logger.error("No city was found.");
            return "ErrorPage";
        }
    }

    @GetMapping(path="/last")
    public String getAirqualityLastDays(@RequestParam String city, Model model){
        City c = null;
        if(cache3.containsCity(city)){
            if(cache3.containsInfo(city)){
                logger.info("Air pollution about the last 5 days for the city " + city + " accessed via cache because it was already requested less then " + TimeUnit.SECONDS.convert(cache1.getAvg(), TimeUnit.NANOSECONDS) + "s ago.");
                model.addAttribute(cache3.getValue(city));
                return "AirQualityLast";
            }
            logger.info("Coordinates for the place called " + city + " were accessed via cache.");
            c = cache3.getCity(city);
        }

        if(c == null)
            c = airQualityGeoLocationService.getCoordsByCity(city);

        if(city!=null && c!=null){
            Map<City, List<Air>> res = new HashMap<>();
            List<Air> lista = airQualityService.getAirLastDays(c);
            res.put(c,lista);
            cache3.add(res);
            logger.info("Air pollution about the last 5 days for the place called " + c.getCity() + " was cached for the next " + TimeUnit.SECONDS.convert(cache3.getAvg(), TimeUnit.NANOSECONDS) + "s.");
            logger.info("AirQualityLast page was accessed to show the stats for the air pollution about the last 5 days for the place " + city + ".");
            model.addAttribute("Air", lista);
            return "AirQualityLast";
        }
        else{
            logger.error("No city was found.");
            return "ErrorPage";
        }
    }

    @GetMapping(path="/AirQuality/now")
    public ResponseEntity<Air> getAirqualitybyLocationAPI(@RequestParam String city){
        City c = null;
        if(cache1.containsCity(city)){
            if(cache1.containsInfo(city)){
                logger.info("Air pollution about today for the city " + city + " accessed via cache because it was already requested less then " + TimeUnit.SECONDS.convert(cache1.getAvg(), TimeUnit.NANOSECONDS) + "s ago.");
                return new ResponseEntity<>(cache1.getValue(city).get(0), HttpStatus.OK);
            }
            logger.info("Coordinates for the place called " + city + " were accessed via cache.");
            c = cache1.getCity(city);
        }

        if(c == null)
            c = airQualityGeoLocationService.getCoordsByCity(city);

        if(city!=null && c!=null){
            Air air = airQualityService.getAirByNow(c);
            if(air!=null){
                Map<City, List<Air>> res = new HashMap<>();
                List<Air> lista = new ArrayList<>();
                lista.add(air);
                res.put(c,lista);
                cache1.add(res);
                logger.info("AirQuality/now API endpoint was accessed to show the stats for the air pollution at the moment for the place " + city + ".");
                logger.info("Air pollution about today for the place called " + c.getCity() + " was cached for the next " + TimeUnit.SECONDS.convert(cache1.getAvg(), TimeUnit.NANOSECONDS) + "s.");
                return new ResponseEntity<>(air,HttpStatus.OK);
            }
            else{
                logger.error("No air pollution data found.");
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        }
        else {
            logger.error("No city found.");
            return new ResponseEntity<>(new Air("",0, 0, 0, 0, 0, 0, 0, 0, 0, 0), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path="/AirQuality/next")
    public ResponseEntity<List<Air>> getAirqualityNextDaysAPI(@RequestParam String city){
        City  c = null;
        if(cache2.containsCity(city)){
            if(cache2.containsInfo(city)){
                logger.info("Air pollution about the next 5 days for the city " + city + " accessed via cache because it was already requested less then " + TimeUnit.SECONDS.convert(cache1.getAvg(), TimeUnit.NANOSECONDS) + "s ago.");
                return new ResponseEntity<>(cache2.getValue(city),HttpStatus.OK);
            }
            logger.info("Coordinates for the place called " + city + " were accessed via cache.");
            c = cache2.getCity(city);
        }

        if(c == null)
            c = airQualityGeoLocationService.getCoordsByCity(city);

        List<Air> air = null;

        if(city!=null && c!=null){
            air = airQualityService.getAirNextDays(c);
            if(air.size()!=0){
                Map<City,List<Air>> res = new HashMap<>();
                res.put(c,air);
                cache2.add(res);
                logger.info("AirQuality/next API endpoint was accessed to show the stats for the air pollution about the next 5 days for the place " + city + ".");
                logger.info("Air pollution about the next 5 days for the place called " + c.getCity() + " was cached for the next " + TimeUnit.SECONDS.convert(cache2.getAvg(), TimeUnit.NANOSECONDS) + "s.");

                return new ResponseEntity<>(air,HttpStatus.OK);
            }
            else{
                logger.error("No air pollution data found.");
                return new ResponseEntity<>(air,HttpStatus.NOT_FOUND);
            }

        }
        else{
            logger.error("No city was found.");
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path="/AirQuality/last")
    public ResponseEntity<List<Air>> getAirqualityLastDaysAPI(@RequestParam String city){
        City c = null;
        if(cache3.containsCity(city)){
            if(cache3.containsInfo(city)){
                logger.info("Air pollution about the last 5 days for the city " + city + " accessed via cache because it was already requested less then " + TimeUnit.SECONDS.convert(cache1.getAvg(), TimeUnit.NANOSECONDS) + "s ago.");
                return new ResponseEntity<>(cache3.getValue(city),HttpStatus.OK);
            }
            logger.info("Coordinates for the place called " + city + " were accessed via cache.");
            c = cache3.getCity(city);
        }

        if(c == null)
            c = airQualityGeoLocationService.getCoordsByCity(city);

        List<Air> air = null;

        if(city!=null){
            air = airQualityService.getAirLastDays(c);
            if(air.size()!=0){
                Map<City, List<Air>> res = new HashMap<>();
                res.put(c,air);
                cache3.add(res);
                logger.info("AirQuality/last API endpoint was accessed to show the stats for the air pollution about the last 5 days for the place " + city + ".");
                logger.info("Air pollution about the last 5 days for the place called " + c.getCity() + " was cached for the next " + TimeUnit.SECONDS.convert(cache3.getAvg(), TimeUnit.NANOSECONDS) + "s.");
                return new ResponseEntity<>(air,HttpStatus.OK);
            }
            else{
                logger.error("There are no city or place with the name " + city + ".");
                return new ResponseEntity<>(air,HttpStatus.NOT_FOUND);
            }
        }
        else{
            logger.error("No city was found.");
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path="/AirQuality/geo")
    public ResponseEntity<City> getGeoLocationbyCityAPI(@RequestParam String city){
        if(cache1.containsCity(city)){
            logger.info("Coordinates for the place called " + city + " were accessed via cache.");
            return new ResponseEntity<>(cache1.getCity(city),HttpStatus.OK);
        }
        if(cache2.containsCity(city)){
            logger.info("Coordinates for the place called " + city + " were accessed via cache.");
            return new ResponseEntity<>(cache2.getCity(city),HttpStatus.OK);
        }

        if(cache3.containsCity(city)){
            logger.info("Coordinates for the place called " + city + " were accessed via cache.");
            return new ResponseEntity<>(cache3.getCity(city),HttpStatus.OK);
        }

        City c = airQualityGeoLocationService.getCoordsByCity(city);

        if(c == null){
            logger.error("There are no coordinates found fot city or place with the name " + city + ".");
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }


        List<Air> air = new ArrayList<>();
        Map<City,List<Air>> res = new HashMap<>();

        res.put(c,air);
        cache1.add(res);
        cache2.add(res);
        cache3.add(res);

        logger.info("AirQuality/geo API endpoint was accessed to request the coordinates of the place called " + c.getCity() + ".");
        logger.info("Coordinates for the place called " + c.getCity() + " was cached for " + TimeUnit.SECONDS.convert(cache3.getAvg(), TimeUnit.NANOSECONDS) + "s.");
        return new ResponseEntity<>(c,HttpStatus.OK);
    }


}

