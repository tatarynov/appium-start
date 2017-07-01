package support.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

    public Geometry(Location location) {
        this.location = location;
    }

    public Geometry() {
    }

    @JsonProperty
    private Location location;

    public Location getLocation() {
        return location;
    }
}
