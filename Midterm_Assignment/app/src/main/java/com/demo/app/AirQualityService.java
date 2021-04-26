package com.demo.app;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirQualityService {

    public Air getAirByNow(float lat, float lon);

    public List<Air> getAirNextDays(float lat, float lon);

    public List<Air> getAirLastDays(float lat, float lon);
}
