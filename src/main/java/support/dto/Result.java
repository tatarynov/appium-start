package support.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    public Result() {
    }

    public Result(Geometry geometry) {
        this.geometry = geometry;
    }


    @JsonProperty
    private Geometry geometry;

    public Geometry getGeometry() {
        return geometry;
    }
}
