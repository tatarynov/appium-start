package support.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import support.weather.dto.GeoDTO;
import support.weather.dto.Location;

import java.io.IOException;

public class HttpRunner {

    static final String GEO_API_KEY = "AIzaSyA6VONhEwIYxDw0xHBjP3aB-GBbWFupCTQ";
    static final String WEATHER_API_KEY = "fcc5e5d9d7f1a7177ebf5ba0522cdd40";
    static final String ADDRESS = "Kyiv";

    public static void main(String[] args) throws IOException {

        String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s",
                ADDRESS, GEO_API_KEY);

        Response response = HttpHelper.get(url);
        String jsonString = response.body().string();

        GeoDTO geoDTO = new ObjectMapper().readValue(jsonString, GeoDTO.class);
        Location location = geoDTO.getLocation(0);

        String urlWeather = String.format("https://api.darksky.net/forecast/%s/%s,%s",
                WEATHER_API_KEY, location.getLat(), location.getLng());
        Response responseWeather = HttpHelper.get(urlWeather);
        String weatherString = responseWeather.body().string();
        System.out.println(weatherString);

    }
}
