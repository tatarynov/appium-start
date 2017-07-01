package support.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Location {

    public Location(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Location() {
    }

    @JsonProperty
    private String lat;

    @JsonProperty
    private String lng;

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
