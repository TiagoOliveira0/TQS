package com.demo.app;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirQualityServiceImpl implements AirQualityService{

    @Value("${api1.key}")
    private String api1Key;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Cache cache;

    @Override
    public Air getAirByNow(float lat, float lon) {

        String json1 = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/air_pollution?lat=" + lat + "&lon=" + lon + "&appid=" + api1Key, String.class);

        JSONObject json = null;
        try {
            json = new JSONObject(json1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(json==null){
            return null;
        }

        Float no2 = null;
        Float no = null;
        Float o3 = null;
        Float so2 = null;
        Float pm2_5 = null;
        Float pm10 = null;
        Float nh3 = null;
        Float co = null;

        try {
            no2 = Float.parseFloat(json.getJSONArray("list").getJSONObject(0).getJSONObject("components").getString("no2"));
            no = Float.parseFloat(json.getJSONArray("list").getJSONObject(0).getJSONObject("components").getString("no"));
            o3 = Float.parseFloat(json.getJSONArray("list").getJSONObject(0).getJSONObject("components").getString("o3"));
            so2 = Float.parseFloat(json.getJSONArray("list").getJSONObject(0).getJSONObject("components").getString("so2"));
            pm2_5 = Float.parseFloat(json.getJSONArray("list").getJSONObject(0).getJSONObject("components").getString("pm2_5"));
            pm10 = Float.parseFloat(json.getJSONArray("list").getJSONObject(0).getJSONObject("components").getString("pm10"));
            nh3 = Float.parseFloat(json.getJSONArray("list").getJSONObject(0).getJSONObject("components").getString("nh3"));
            co = Float.parseFloat(json.getJSONArray("list").getJSONObject(0).getJSONObject("components").getString("co"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(no2!=null && no!=null && o3!=null && so2!=null && pm2_5!=null && pm10!=null && nh3!=null && co!=null){
            return new Air(lat,lon,co,no,no2,o3,so2,pm2_5,pm10,nh3);
        }

        return new Air(0,0,0,0,0,0,0,0,0,0);
    }

    @Override
    public List<Air> getAirNextDays(float lat, float lon){

        long now = Instant.now().getEpochSecond();

        Instant instant1 = Instant.ofEpochSecond(now);

        Integer today = LocalDateTime.ofInstant(instant1, ZoneOffset.UTC).getDayOfYear();

        Integer last = 0;

        String json1 = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/air_pollution/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + api1Key, String.class);

        JSONObject json = null;
        try {
            json = new JSONObject(json1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(json==null){
            return null;
        }

        List<Air> lista = new ArrayList<>();

        int tam = 0;

        try {
            tam = json.getJSONArray("list").length();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(tam==0){
            return null;
        }   

        for(int i=0; i<tam;i++) {
            Float no2 = null;
            Float no = null;
            Float o3 = null;
            Float so2 = null;
            Float pm2_5 = null;
            Float pm10 = null;
            Float nh3 = null;
            Float co = null;

            Integer day = null;

            try {
                no2 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("no2"));
                no = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("no"));
                o3 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("o3"));
                so2 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("so2"));
                pm2_5 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("pm2_5"));
                pm10 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("pm10"));
                nh3 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("nh3"));
                co = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("co"));

                day = Integer.parseInt(json.getJSONArray("list").getJSONObject(i).getString("dt"));

                Instant instant = Instant.ofEpochSecond(day);

                day = LocalDateTime.ofInstant(instant, ZoneOffset.UTC).getDayOfYear();

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if(last == 0 && day!=null){
                last=day;
            }

            if(no2!=null && no!=null && o3!=null && so2!=null && pm2_5!=null && pm10!=null && nh3!=null && co!=null && day!=null && day!=last && day>today){
                lista.add(new Air(lat,lon,co,no,no2,o3,so2,pm2_5,pm10,nh3));
                last=day;
            }
        }

        return lista;

    }

    @Override
    public List<Air> getAirLastDays(float lat, float lon) {

        long now = Instant.now().getEpochSecond();

        Instant instant1 = Instant.ofEpochSecond(now);

        Integer today = LocalDateTime.ofInstant(instant1, ZoneOffset.UTC).getDayOfYear();

        Integer last = 0;

        String json1 = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/air_pollution/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + api1Key, String.class);

        JSONObject json = null;
        try {
            json = new JSONObject(json1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(json==null){
            return null;
        }

        List<Air> lista = new ArrayList<>();

        int tam = 0;

        try {
            tam = json.getJSONArray("list").length();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(tam==0){
            return null;
        }

        for(int i=0; i<tam;i++) {
            Float no2 = null;
            Float no = null;
            Float o3 = null;
            Float so2 = null;
            Float pm2_5 = null;
            Float pm10 = null;
            Float nh3 = null;
            Float co = null;

            Integer day = null;

            try {
                no2 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("no2"));
                no = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("no"));
                o3 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("o3"));
                so2 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("so2"));
                pm2_5 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("pm2_5"));
                pm10 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("pm10"));
                nh3 = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("nh3"));
                co = Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("components").getString("co"));

                day = Integer.parseInt(json.getJSONArray("list").getJSONObject(i).getString("dt"));

                Instant instant = Instant.ofEpochSecond(day);

                day = LocalDateTime.ofInstant(instant, ZoneOffset.UTC).getDayOfYear();

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if(last == 0 && day!=null){
                last=day;
            }

            if(no2!=null && no!=null && o3!=null && so2!=null && pm2_5!=null && pm10!=null && nh3!=null && co!=null && day!=null && day!=last && day<=today){
                lista.add(new Air(lat,lon,co,no,no2,o3,so2,pm2_5,pm10,nh3));
                last=day;
            }

        }

        return lista;
    }
}
