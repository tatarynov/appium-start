package support.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;

@JsonSerialize
public class GoogleGeoDTO {

    public GoogleGeoDTO(ArrayList<Result> results, String status) {
        this.results = results;
        this.status = status;
    }

    public GoogleGeoDTO() {
    }

    @JsonProperty
    private ArrayList<Result> results;

    @JsonProperty
    private String status;

    public Location getLocation() {
        return results.get(0).getGeometry().getLocation();
    }
}
