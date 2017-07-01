package support.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoDTO {

    @JsonProperty
    private ArrayList<Result> results;

    @JsonProperty
    private String status;

    public Location getLocation(int result) {
        return results.get(result).getGeometry().getLocation();
    }
}
