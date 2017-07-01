package support.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import support.dto.GoogleGeoDTO;

import java.io.IOException;

public class HttpRunner {

    static final String GEO_API_KEY = "AIzaSyA6VONhEwIYxDw0xHBjP3aB-GBbWFupCTQ";
    static final String ADDRESS = "Kyiv";

    public static void main(String[] args) throws IOException {

        // https://developers.google.com/maps/documentation/geocoding/intro - где можно получить свой API Key

        String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s",
                ADDRESS, GEO_API_KEY);
        Response response = HttpHelper.makeCall(url);
        String body = response.body().string();

        GoogleGeoDTO googleGeoDTO = new ObjectMapper().readValue(body, GoogleGeoDTO.class);
    }
}
