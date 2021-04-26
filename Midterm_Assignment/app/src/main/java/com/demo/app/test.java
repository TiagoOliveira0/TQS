package com.demo.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.cglib.core.internal.LoadingCache;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String agrs[]) throws JSONException, InterruptedException {
        String s = "{\"coord\":{\"lon\":-8.5745,\"lat\":41.0232},\"list\":[{\"main\":{\"aqi\":1},\"components\":{\"co\":223.64,\"no\":0.13,\"no2\":7.8,\"o3\":64.37,\"so2\":2.47,\"pm2_5\":2.96,\"pm10\":3.91,\"nh3\":2.28},\"dt\":1619287200}]}";

        String ss = "{\"coord\":{\"lon\":-8.5746,\"lat\":41.0232},\"list\":[{\"main\":{\"aqi\":1},\"components\":{\"co\":203.61,\"no\":0,\"no2\":4.67,\"o3\":64.37,\"so2\":1.27,\"pm2_5\":6.05,\"pm10\":6.65,\"nh3\":0.23},\"dt\":1606266000},{\"main\":{\"aqi\":1},\"components\":{\"co\":201.94,\"no\":0,\"no2\":3.94,\"o3\":62.23,\"so2\":1.07,\"pm2_5\":5.33,\"pm10\":5.78,\"nh3\":0.25},\"dt\":1606269600},{\"main\":{\"aqi\":1},\"components\":{\"co\":200.27,\"no\":0,\"no2\":3.47,\"o3\":59.37,\"so2\":0.93,\"pm2_5\":4.81,\"pm10\":5.15,\"nh3\":0.26},\"dt\":1606273200},{\"main\":{\"aqi\":1},\"components\":{\"co\":200.27,\"no\":0,\"no2\":3.09,\"o3\":55.79,\"so2\":0.75,\"pm2_5\":4.41,\"pm10\":4.74,\"nh3\":0.3},\"dt\":1606276800},{\"main\":{\"aqi\":1},\"components\":{\"co\":201.94,\"no\":0,\"no2\":3.17,\"o3\":50.78,\"so2\":0.72,\"pm2_5\":4.11,\"pm10\":4.52,\"nh3\":0.37},\"dt\":1606280400},{\"main\":{\"aqi\":1},\"components\":{\"co\":213.62,\"no\":0,\"no2\":4.67,\"o3\":46.49,\"so2\":1.22,\"pm2_5\":4.05,\"pm10\":4.65,\"nh3\":0.42},\"dt\":1606284000},{\"main\":{\"aqi\":1},\"components\":{\"co\":267.03,\"no\":0.01,\"no2\":11.31,\"o3\":38.27,\"so2\":2.77,\"pm2_5\":5.32,\"pm10\":6.23,\"nh3\":0.62},\"dt\":1606287600},{\"main\":{\"aqi\":1},\"components\":{\"co\":330.45,\"no\":0.06,\"no2\":20.91,\"o3\":28.97,\"so2\":3.82,\"pm2_5\":6.65,\"pm10\":7.74,\"nh3\":0.67},\"dt\":1606291200},{\"main\":{\"aqi\":1},\"components\":{\"co\":323.77,\"no\":0.1,\"no2\":20.91,\"o3\":30.04,\"so2\":3.87,\"pm2_5\":5.64,\"pm10\":6.67,\"nh3\":0.63},\"dt\":1606294800},{\"main\":{\"aqi\":1},\"components\":{\"co\":257.02,\"no\":0.11,\"no2\":11.65,\"o3\":45.06,\"so2\":3.49,\"pm2_5\":3.1,\"pm10\":3.86,\"nh3\":0.48},\"dt\":1606298400},{\"main\":{\"aqi\":1},\"components\":{\"co\":247,\"no\":0.22,\"no2\":10.11,\"o3\":47.21,\"so2\":3.1,\"pm2_5\":2.77,\"pm10\":3.39,\"nh3\":0.47},\"dt\":1606302000},{\"main\":{\"aqi\":1},\"components\":{\"co\":247,\"no\":0.33,\"no2\":9.51,\"o3\":47.21,\"so2\":2.74,\"pm2_5\":2.66,\"pm10\":3.17,\"nh3\":0.44},\"dt\":1606305600},{\"main\":{\"aqi\":1},\"components\":{\"co\":240.33,\"no\":0.37,\"no2\":8.74,\"o3\":47.92,\"so2\":2.62,\"pm2_5\":2.46,\"pm10\":2.9,\"nh3\":0.42},\"dt\":1606309200},{\"main\":{\"aqi\":1},\"components\":{\"co\":236.99,\"no\":0.31,\"no2\":9.25,\"o3\":48.64,\"so2\":2.77,\"pm2_5\":2.47,\"pm10\":2.9,\"nh3\":0.43},\"dt\":1606312800},{\"main\":{\"aqi\":1},\"components\":{\"co\":233.65,\"no\":0.19,\"no2\":10.37,\"o3\":49.35,\"so2\":2.92,\"pm2_5\":2.66,\"pm10\":3.09,\"nh3\":0.46},\"dt\":1606316400},{\"main\":{\"aqi\":1},\"components\":{\"co\":253.68,\"no\":0.14,\"no2\":15.59,\"o3\":41.13,\"so2\":3.67,\"pm2_5\":3.42,\"pm10\":4.01,\"nh3\":0.63},\"dt\":1606320000},{\"main\":{\"aqi\":1},\"components\":{\"co\":290.39,\"no\":0.12,\"no2\":25.02,\"o3\":26.82,\"so2\":4.71,\"pm2_5\":4.66,\"pm10\":5.52,\"nh3\":0.82},\"dt\":1606323600},{\"main\":{\"aqi\":1},\"components\":{\"co\":313.76,\"no\":0.16,\"no2\":30.16,\"o3\":19.31,\"so2\":5.13,\"pm2_5\":5.39,\"pm10\":6.41,\"nh3\":0.87},\"dt\":1606327200},{\"main\":{\"aqi\":1},\"components\":{\"co\":367.17,\"no\":0.69,\"no2\":34.62,\"o3\":11.44,\"so2\":4.77,\"pm2_5\":7.28,\"pm10\":8.7,\"nh3\":1.03},\"dt\":1606330800},{\"main\":{\"aqi\":2},\"components\":{\"co\":473.98,\"no\":2.99,\"no2\":39.07,\"o3\":2.59,\"so2\":4.41,\"pm2_5\":11.76,\"pm10\":13.89,\"nh3\":1.39},\"dt\":1606334400},{\"main\":{\"aqi\":2},\"components\":{\"co\":554.09,\"no\":5.81,\"no2\":37.7,\"o3\":0.56,\"so2\":4.17,\"pm2_5\":15.69,\"pm10\":18.43,\"nh3\":1.71},\"dt\":1606338000},{\"main\":{\"aqi\":2},\"components\":{\"co\":554.09,\"no\":6.48,\"no2\":33.93,\"o3\":0.34,\"so2\":3.61,\"pm2_5\":16.39,\"pm10\":19.41,\"nh3\":1.77},\"dt\":1606341600},{\"main\":{\"aqi\":2},\"components\":{\"co\":480.65,\"no\":5.36,\"no2\":27.76,\"o3\":0.43,\"so2\":2.5,\"pm2_5\":13.71,\"pm10\":16.52,\"nh3\":1.36},\"dt\":1606345200},{\"main\":{\"aqi\":1},\"components\":{\"co\":373.84,\"no\":2.96,\"no2\":21.42,\"o3\":1.14,\"so2\":1.43,\"pm2_5\":9.93,\"pm10\":12.2,\"nh3\":0.95},\"dt\":1606348800},{\"main\":{\"aqi\":1},\"components\":{\"co\":300.41,\"no\":0.89,\"no2\":15.77,\"o3\":3.22,\"so2\":1.04,\"pm2_5\":7.67,\"pm10\":9.53,\"nh3\":0.77},\"dt\":1606352400},{\"main\":{\"aqi\":1},\"components\":{\"co\":260.35,\"no\":0.19,\"no2\":10.97,\"o3\":7.06,\"so2\":0.89,\"pm2_5\":6.7,\"pm10\":8.27,\"nh3\":0.57},\"dt\":1606356000},{\"main\":{\"aqi\":1},\"components\":{\"co\":236.99,\"no\":0.05,\"no2\":7.63,\"o3\":11.62,\"so2\":0.68,\"pm2_5\":5.76,\"pm10\":7.1,\"nh3\":0.4},\"dt\":1606359600},{\"main\":{\"aqi\":1},\"components\":{\"co\":220.3,\"no\":0.02,\"no2\":5.57,\"o3\":17.35,\"so2\":0.54,\"pm2_5\":4.66,\"pm10\":5.71,\"nh3\":0.33},\"dt\":1606363200},{\"main\":{\"aqi\":1},\"components\":{\"co\":211.95,\"no\":0.01,\"no2\":4.67,\"o3\":20.74,\"so2\":0.45,\"pm2_5\":3.76,\"pm10\":4.62,\"nh3\":0.34},\"dt\":1606366800},{\"main\":{\"aqi\":1},\"components\":{\"co\":210.29,\"no\":0.02,\"no2\":5.06,\"o3\":21.99,\"so2\":0.43,\"pm2_5\":3.3,\"pm10\":4.03,\"nh3\":0.36},\"dt\":1606370400},{\"main\":{\"aqi\":1},\"components\":{\"co\":213.62,\"no\":0.07,\"no2\":6.68,\"o3\":20.39,\"so2\":0.54,\"pm2_5\":3,\"pm10\":3.75,\"nh3\":0.42},\"dt\":1606374000},{\"main\":{\"aqi\":1},\"components\":{\"co\":220.3,\"no\":0.19,\"no2\":9.6,\"o3\":16.99,\"so2\":0.66,\"pm2_5\":2.6,\"pm10\":3.44,\"nh3\":0.48},\"dt\":1606377600},{\"main\":{\"aqi\":1},\"components\":{\"co\":223.64,\"no\":0.26,\"no2\":10.71,\"o3\":17.35,\"so2\":0.74,\"pm2_5\":2.14,\"pm10\":3,\"nh3\":0.48},\"dt\":1606381200},{\"main\":{\"aqi\":1},\"components\":{\"co\":220.3,\"no\":0.38,\"no2\":8.4,\"o3\":23.6,\"so2\":0.73,\"pm2_5\":1.58,\"pm10\":2.33,\"nh3\":0.44},\"dt\":1606384800},{\"main\":{\"aqi\":1},\"components\":{\"co\":210.29,\"no\":0.44,\"no2\":6.34,\"o3\":36.12,\"so2\":0.71,\"pm2_5\":1.17,\"pm10\":1.81,\"nh3\":0.46},\"dt\":1606388400},{\"main\":{\"aqi\":1},\"components\":{\"co\":201.94,\"no\":0.41,\"no2\":4.88,\"o3\":53.64,\"so2\":0.72,\"pm2_5\":0.83,\"pm10\":1.37,\"nh3\":0.46},\"dt\":1606392000},{\"main\":{\"aqi\":1},\"components\":{\"co\":190.26,\"no\":0.32,\"no2\":3.26,\"o3\":65.8,\"so2\":0.71,\"pm2_5\":0.5,\"pm10\":0.79,\"nh3\":0.32},\"dt\":1606395600},{\"main\":{\"aqi\":1},\"components\":{\"co\":190.26,\"no\":0.3,\"no2\":3.26,\"o3\":58.65,\"so2\":0.87,\"pm2_5\":0.63,\"pm10\":0.86,\"nh3\":0.28},\"dt\":1606399200},{\"main\":{\"aqi\":1},\"components\":{\"co\":188.59,\"no\":0.2,\"no2\":3.26,\"o3\":58.65,\"so2\":0.86,\"pm2_5\":0.81,\"pm10\":1.02,\"nh3\":0.3},\"dt\":1606402800},{\"main\":{\"aqi\":1},\"components\":{\"co\":193.6,\"no\":0.09,\"no2\":5.27,\"o3\":57.94,\"so2\":0.89,\"pm2_5\":0.96,\"pm10\":1.25,\"nh3\":0.4},\"dt\":1606406400},{\"main\":{\"aqi\":1},\"components\":{\"co\":203.61,\"no\":0.02,\"no2\":8.48,\"o3\":51.5,\"so2\":0.9,\"pm2_5\":1.23,\"pm10\":1.65,\"nh3\":0.54},\"dt\":1606410000},{\"main\":{\"aqi\":1},\"components\":{\"co\":211.95,\"no\":0,\"no2\":10.28,\"o3\":47.92,\"so2\":0.87,\"pm2_5\":1.43,\"pm10\":1.97,\"nh3\":0.6},\"dt\":1606413600},{\"main\":{\"aqi\":1},\"components\":{\"co\":240.33,\"no\":0.01,\"no2\":13.71,\"o3\":42.2,\"so2\":1.09,\"pm2_5\":2.28,\"pm10\":2.99,\"nh3\":0.69},\"dt\":1606417200},{\"main\":{\"aqi\":1},\"components\":{\"co\":307.08,\"no\":0.06,\"no2\":18.34,\"o3\":29.68,\"so2\":1.52,\"pm2_5\":4.37,\"pm10\":5.43,\"nh3\":0.82},\"dt\":1606420800},{\"main\":{\"aqi\":1},\"components\":{\"co\":393.87,\"no\":0.27,\"no2\":22.28,\"o3\":17.17,\"so2\":1.94,\"pm2_5\":7.47,\"pm10\":8.87,\"nh3\":0.88},\"dt\":1606424400},{\"main\":{\"aqi\":2},\"components\":{\"co\":467.3,\"no\":0.91,\"no2\":25.02,\"o3\":8.05,\"so2\":2.24,\"pm2_5\":10.43,\"pm10\":12.09,\"nh3\":0.93},\"dt\":1606428000},{\"main\":{\"aqi\":2},\"components\":{\"co\":487.33,\"no\":1.87,\"no2\":25.02,\"o3\":3.93,\"so2\":2.12,\"pm2_5\":11.49,\"pm10\":13.25,\"nh3\":0.89},\"dt\":1606431600},{\"main\":{\"aqi\":2},\"components\":{\"co\":460.63,\"no\":2.04,\"no2\":23.99,\"o3\":2.71,\"so2\":1.76,\"pm2_5\":10.86,\"pm10\":12.5,\"nh3\":0.75},\"dt\":1606435200},{\"main\":{\"aqi\":2},\"components\":{\"co\":433.92,\"no\":1.79,\"no2\":21.76,\"o3\":1.79,\"so2\":1.52,\"pm2_5\":10.21,\"pm10\":11.98,\"nh3\":0.85},\"dt\":1606438800},{\"main\":{\"aqi\":1},\"components\":{\"co\":403.88,\"no\":1.65,\"no2\":17.99,\"o3\":1.3,\"so2\":1.49,\"pm2_5\":9.56,\"pm10\":11.54,\"nh3\":1.11},\"dt\":1606442400},{\"main\":{\"aqi\":1},\"components\":{\"co\":363.83,\"no\":0.92,\"no2\":14.22,\"o3\":2.26,\"so2\":1.46,\"pm2_5\":8.17,\"pm10\":10.21,\"nh3\":1.28},\"dt\":1606446000},{\"main\":{\"aqi\":1},\"components\":{\"co\":323.77,\"no\":0.39,\"no2\":10.8,\"o3\":4.38,\"so2\":1.37,\"pm2_5\":6.71,\"pm10\":8.64,\"nh3\":1.3},\"dt\":1606449600},{\"main\":{\"aqi\":1},\"components\":{\"co\":287.06,\"no\":0.24,\"no2\":7.88,\"o3\":7.06,\"so2\":1,\"pm2_5\":5.2,\"pm10\":6.92,\"nh3\":0.97},\"dt\":1606453200},{\"main\":{\"aqi\":1},\"components\":{\"co\":260.35,\"no\":0.25,\"no2\":7.11,\"o3\":10.01,\"so2\":0.72,\"pm2_5\":3.93,\"pm10\":5.41,\"nh3\":0.59},\"dt\":1606456800},{\"main\":{\"aqi\":1},\"components\":{\"co\":243.66,\"no\":0.13,\"no2\":8.65,\"o3\":20.03,\"so2\":0.83,\"pm2_5\":2.8,\"pm10\":3.91,\"nh3\":0.42},\"dt\":1606460400},{\"main\":{\"aqi\":1},\"components\":{\"co\":270.37,\"no\":0.37,\"no2\":15.25,\"o3\":15.56,\"so2\":1.1,\"pm2_5\":3.48,\"pm10\":4.69,\"nh3\":0.48},\"dt\":1606464000},{\"main\":{\"aqi\":1},\"components\":{\"co\":297.07,\"no\":2.24,\"no2\":17.99,\"o3\":13.23,\"so2\":1.33,\"pm2_5\":4.39,\"pm10\":5.74,\"nh3\":0.53},\"dt\":1606467600},{\"main\":{\"aqi\":1},\"components\":{\"co\":313.76,\"no\":6.09,\"no2\":14.4,\"o3\":16.99,\"so2\":1.48,\"pm2_5\":4.94,\"pm10\":6.43,\"nh3\":0.59},\"dt\":1606471200},{\"main\":{\"aqi\":1},\"components\":{\"co\":330.45,\"no\":8.94,\"no2\":11.48,\"o3\":17.52,\"so2\":1.73,\"pm2_5\":5.47,\"pm10\":7.12,\"nh3\":0.71},\"dt\":1606474800},{\"main\":{\"aqi\":1},\"components\":{\"co\":340.46,\"no\":10.17,\"no2\":10.45,\"o3\":17.52,\"so2\":2.12,\"pm2_5\":5.82,\"pm10\":7.59,\"nh3\":0.89},\"dt\":1606478400},{\"main\":{\"aqi\":1},\"components\":{\"co\":257.02,\"no\":3.21,\"no2\":8.48,\"o3\":44.35,\"so2\":2.77,\"pm2_5\":2.77,\"pm10\":3.71,\"nh3\":0.74},\"dt\":1606482000}]}";

        JSONObject json = new JSONObject(s);

        JSONObject json1 = new JSONObject(ss);
        System.out.println(json.toString());

        JSONObject s1 = json1.getJSONArray("list").getJSONObject(0).getJSONObject("components");

        String no2 = s1.getString("no2");
        System.out.println(json1.getJSONArray("list").length());


        long unixTime = Instant.now().getEpochSecond();


        Instant instant = Instant.ofEpochSecond(unixTime);

        String num = json.getJSONArray("list").getJSONObject(0).getString("dt");

        System.out.println(num);

        System.out.println(LocalDateTime.ofInstant(instant, ZoneOffset.UTC).getHour());


        Cache cache = new Cache(10000000000L ,10000000000L);

        List<Air> dados = new ArrayList<>();

        Air a1 = new Air(1,1,1,1,1,1,1,1,1,1);
        Air a2 = new Air(2,2,2,2,2,2,2,2,2,2);
        Air a3 = new Air(3,3,3,3,3,3,3,3,3,3);

        dados.add(a1);
        dados.add(a2);
        dados.add(a3);

        Map<String, List<Air>> ret = new HashMap<>();

        ret.put("Coimbra", dados);

        Map<String, List<Air>> ret1 = new HashMap<>();
        ret1.put("Aveiro",dados);

        boolean b = Cache.add(ret);
        boolean b1 = Cache.add(ret1);

        System.out.println(b);

        /*
        System.out.println(cache.getValue("Aveiro"));

        TimeUnit.MINUTES.sleep(1);


        System.out.println(cache.getValue("Aveiro"));
        */


        String c = "{\"documentation\":\"https://opencagedata.com/api\",\"licenses\":[{\"name\":\"see attribution guide\",\"url\":\"https://opencagedata.com/credits\"}],\"rate\":{\"limit\":2500,\"remaining\":2489,\"reset\":1619481600},\"results\":[{\"annotations\":{\"DMS\":{\"lat\":\"41\\u00b0 1' 23.49192'' N\",\"lng\":\"8\\u00b0 34' 28.62156'' W\"},\"MGRS\":\"29TNF3576241418\",\"Maidenhead\":\"IN51ra15bn\",\"Mercator\":{\"x\":-954522.009,\"y\":4987710.886},\"OSM\":{\"edit_url\":\"https://www.openstreetmap.org/edit?way=298322109#map=17/41.02319/-8.57462\",\"note_url\":\"https://www.openstreetmap.org/note/new#map=17/41.02319/-8.57462&layers=N\",\"url\":\"https://www.openstreetmap.org/?mlat=41.02319&mlon=-8.57462#map=17/41.02319/-8.57462\"},\"UN_M49\":{\"regions\":{\"EUROPE\":\"150\",\"PT\":\"620\",\"SOUTHERN_EUROPE\":\"039\",\"WORLD\":\"001\"},\"statistical_groupings\":[\"MEDC\"]},\"callingcode\":351,\"currency\":{\"alternate_symbols\":[],\"decimal_mark\":\",\",\"html_entity\":\"&#x20AC;\",\"iso_code\":\"EUR\",\"iso_numeric\":\"978\",\"name\":\"Euro\",\"smallest_denomination\":1,\"subunit\":\"Cent\",\"subunit_to_unit\":100,\"symbol\":\"\\u20ac\",\"symbol_first\":0,\"thousands_separator\":\".\"},\"flag\":\"\\ud83c\\uddf5\\ud83c\\uddf9\",\"geohash\":\"ez3ckuh1kvq16w1dpt7c\",\"qibla\":100.59,\"roadinfo\":{\"drive_on\":\"right\",\"road\":\"Rua da Morgadinha\",\"speed_in\":\"km/h\"},\"sun\":{\"rise\":{\"apparent\":1619415600,\"astronomical\":1619409420,\"civil\":1619413860,\"nautical\":1619411700},\"set\":{\"apparent\":1619465100,\"astronomical\":1619471280,\"civil\":1619466840,\"nautical\":1619469000}},\"timezone\":{\"name\":\"Europe/Lisbon\",\"now_in_dst\":1,\"offset_sec\":3600,\"offset_string\":\"+0100\",\"short_name\":\"WEST\"},\"what3words\":{\"words\":\"tumble.dads.replaces\"}},\"bounds\":{\"northeast\":{\"lat\":41.0243044,\"lng\":-8.5734943},\"southwest\":{\"lat\":41.0225644,\"lng\":-8.575235}},\"components\":{\"ISO_3166-1_alpha-2\":\"PT\",\"ISO_3166-1_alpha-3\":\"PRT\",\"_category\":\"road\",\"_type\":\"road\",\"city_district\":\"Grij\\u00f3 e Sermonde\",\"continent\":\"Europe\",\"country\":\"Portugal\",\"country_code\":\"pt\",\"county\":\"Porto\",\"county_code\":\"PRT\",\"political_union\":\"European Union\",\"postcode\":\"4415-533\",\"road\":\"Rua da Morgadinha\",\"state\":\"North\",\"state_district\":\"\\u00c1rea Metropolitana do Porto\",\"town\":\"Vila Nova de Gaia\",\"village\":\"Grij\\u00f3\"},\"confidence\":9,\"formatted\":\"Rua da Morgadinha, 4415-533 Vila Nova de Gaia, Portugal\",\"geometry\":{\"lat\":41.0231922,\"lng\":-8.5746171}},{\"annotations\":{\"DMS\":{\"lat\":\"0\\u00b0 3' 29.98800'' N\",\"lng\":\"51\\u00b0 10' 54.01200'' W\"},\"MGRS\":\"22MDE7978493552\",\"Maidenhead\":\"GI49jw86ea\",\"Mercator\":{\"x\":-5697517.442,\"y\":-6449.799},\"OSM\":{\"note_url\":\"https://www.openstreetmap.org/note/new#map=17/-0.05833/-51.18167&layers=N\",\"url\":\"https://www.openstreetmap.org/?mlat=-0.05833&mlon=-51.18167#map=17/-0.05833/-51.18167\"},\"UN_M49\":{\"regions\":{\"AMERICAS\":\"019\",\"BR\":\"076\",\"LATIN_AMERICA\":\"419\",\"SOUTH_AMERICA\":\"005\",\"WORLD\":\"001\"},\"statistical_groupings\":[\"LEDC\"]},\"callingcode\":55,\"currency\":{\"decimal_mark\":\",\",\"html_entity\":\"R$\",\"iso_code\":\"BRL\",\"iso_numeric\":\"986\",\"name\":\"Brazilian Real\",\"smallest_denomination\":5,\"subunit\":\"Centavo\",\"subunit_to_unit\":100,\"symbol\":\"R$\",\"symbol_first\":1,\"thousands_separator\":\".\"},\"flag\":\"\\ud83c\\udde7\\ud83c\\uddf7\",\"geohash\":\"6zgxem6shwkzbrvksefk\",\"qibla\":68.58,\"roadinfo\":{\"drive_on\":\"right\",\"speed_in\":\"km/h\"},\"sun\":{\"rise\":{\"apparent\":1619428800,\"astronomical\":1619424600,\"civil\":1619427540,\"nautical\":1619426040},\"set\":{\"apparent\":1619472300,\"astronomical\":1619476500,\"civil\":1619473560,\"nautical\":1619475060}},\"timezone\":{\"name\":\"America/Belem\",\"now_in_dst\":0,\"offset_sec\":-10800,\"offset_string\":\"-0300\",\"short_name\":\"-03\"},\"what3words\":{\"words\":\"betrayed.highs.doctor\"}},\"bounds\":{\"northeast\":{\"lat\":0.0195292,\"lng\":-51.106928},\"southwest\":{\"lat\":-0.0927175,\"lng\":-51.2619925}},\"components\":{\"ISO_3166-1_alpha-2\":\"BR\",\"ISO_3166-1_alpha-3\":\"BRA\",\"_category\":\"place\",\"_type\":\"city\",\"continent\":\"South America\",\"country\":\"Brazil\",\"country_code\":\"br\",\"county\":\"Santana\",\"state\":\"Amap\\u00e1\",\"state_code\":\"AP\",\"town\":\"Santana\"},\"confidence\":5,\"formatted\":\"Santana, Brazil\",\"geometry\":{\"lat\":-0.05833,\"lng\":-51.18167}}],\"status\":{\"code\":200,\"message\":\"OK\"},\"stay_informed\":{\"blog\":\"https://blog.opencagedata.com\",\"twitter\":\"https://twitter.com/OpenCage\"},\"thanks\":\"For using an OpenCage API\",\"timestamp\":{\"created_http\":\"Mon, 26 Apr 2021 14:23:40 GMT\",\"created_unix\":1619447020},\"total_results\":2}";

        JSONObject son = new JSONObject(c);

        String l2 = son.getJSONArray("results").getJSONObject(0).getJSONObject("bounds").getJSONObject("southwest").getString("lng");
        String l1 = son.getJSONArray("results").getJSONObject(0).getJSONObject("bounds").getJSONObject("southwest").getString("lat");
        System.out.println(l2 + l1);





    }
}
